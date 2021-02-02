package movie.quiz.service.resource;

import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movie.quiz.api.resource.ResourceException;
import movie.quiz.api.resource.ResourceProvider;
import movie.quiz.common.JsonUtilities;
import movie.quiz.model.resource.DefaultMovie;
import movie.quiz.service.ApiKeyHandler;
import movie.quiz.service.resource.request.RandomMovieResourceRequest;

@Component
public class RandomMovieResource extends AbstractResource implements ResourceProvider<DefaultMovie, RandomMovieResourceRequest> {

	public static final String MOVIES_URL = "https://api.themoviedb.org/3/discover/movie?with_original_language=en&vote_count.gte=5000&api_key=%s";
	
	@Autowired 
	private ApiKeyHandler apiKeyHandler;
	
	private Random rand;
	private Map<Integer, JSONObject> cachedResponse;
	private int totalPages = -1;
	
	public RandomMovieResource() {
		this.rand = new Random();
		this.cachedResponse = new ConcurrentHashMap<>();
	}
	
	@Override
	public DefaultMovie get(RandomMovieResourceRequest request) throws ResourceException {
		try {			
			JSONObject jsonObject = getRandomMovieResponse();
			return createMovieResource(jsonObject);
		} catch (Exception e) {
			String msg = "Unable to get movie resource";
			throw new ResourceException(msg, e);
		}
	}

	private DefaultMovie createMovieResource(JSONObject jsonObject) {
		Integer movieId = jsonObject.getInt("id");
		String title = jsonObject.getString("title");
		String releaseDate = jsonObject.getString("release_date");
		String year = releaseDate.substring(0, releaseDate.indexOf("-"));
		return new DefaultMovie(movieId, title, year);
	}

	private JSONObject getRandomMovieResponse() {
		JSONObject pagedResponse = getPagedResponse();
		JSONArray results = pagedResponse.getJSONArray("results");
		int randomResult = this.rand.nextInt(results.length());
		return results.getJSONObject(randomResult);
	}

	private JSONObject getPagedResponse() {
		String pathWithApiKey = String.format(MOVIES_URL, this.apiKeyHandler.getApiKey());
		int randomPage = this.rand.nextInt(getTotalPages()) + 1;
		return this.cachedResponse.computeIfAbsent(randomPage, r -> requestPagedResponse(pathWithApiKey, randomPage));
	}

	private JSONObject requestPagedResponse(String pathWithApiKey, int randomPage) {
		String path = pathWithApiKey + "&page=" + randomPage;
		URL randomPageUrl = createUrl(path);
		return JsonUtilities.getJsonResponse(randomPageUrl);
	}

	private int getTotalPages() {
		if(this.totalPages == -1) {
			this.totalPages = getTotalNumberPages();
		}
		return this.totalPages;
	}
	
	private int getTotalNumberPages() {
		String pathWithApiKey = String.format(MOVIES_URL, this.apiKeyHandler.getApiKey());
		URL initialPageUrl = createUrl(pathWithApiKey);
		JSONObject response = JsonUtilities.getJsonResponse(initialPageUrl);
		return response.getInt("total_pages");
	}
}
