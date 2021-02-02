package movie.quiz.service.resource;

import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movie.quiz.api.resource.ResourceException;
import movie.quiz.common.JsonUtilities;
import movie.quiz.model.resource.DefaultMovie;
import movie.quiz.service.ApiKeyHandler;
import movie.quiz.service.resource.request.MovieResourceRequest;

@Component
public class MovieResource extends AbstractResource {

	public static final String MOVIES_URL = "https://api.themoviedb.org/3/movie/%d?api_key=%s&language=en-US";

	@Autowired 
	private ApiKeyHandler apiKeyHandler;

	public DefaultMovie get(MovieResourceRequest request) throws ResourceException {
		try {
		String pathWithApiKey = String.format(MOVIES_URL, request.getMovieId(), this.apiKeyHandler.getApiKey());
		URL initialPageUrl = createUrl(pathWithApiKey);
		JSONObject jsonObject = JsonUtilities.getJsonResponse(initialPageUrl);
		String title = jsonObject.getString("title");
		String releaseDate = jsonObject.getString("release_date");
		String year = releaseDate.substring(0, releaseDate.indexOf("-"));
		return new DefaultMovie(request.getMovieId(), title, year);
		} catch (Exception e) {
			String msg = String.format("Unable to get movie resource for id: %d", request.getMovieId());
			throw new ResourceException(msg, e);
		}
	}
}
