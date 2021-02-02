package movie.quiz.service.resource;

import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movie.quiz.api.resource.ResourceException;
import movie.quiz.api.resource.ResourceProvider;
import movie.quiz.common.JsonUtilities;
import movie.quiz.model.resource.DefaultImage;
import movie.quiz.service.ApiKeyHandler;
import movie.quiz.service.resource.request.ImageResourceRequest;

@Component
public class MovieImageResource extends AbstractResource implements ResourceProvider<DefaultImage, ImageResourceRequest>{

	public static final String CONFIGURATION_URL = "https://api.themoviedb.org/3/configuration?api_key=%s";
	public static final String MOVIE_URL = "https://api.themoviedb.org/3/movie/%d?api_key=%s";
	public static final String IMAGE_SIZE = "original";
	
	@Autowired 
	private ApiKeyHandler apiKeyHandler;
	
	@Override
	public DefaultImage get(ImageResourceRequest request) throws ResourceException {
		try {
			String imagePath = buildImagePath(request.getMovieId());
			return new DefaultImage(imagePath);
		} catch (Exception e) {
			String msg = String.format("Unable to get image resource for movie id: %d", request.getMovieId());
			throw new ResourceException(msg, e);
		}
	}

	private String buildImagePath(int movieId) {
		StringBuilder stringBuilder = new StringBuilder(buildBasePath());
		stringBuilder.append(IMAGE_SIZE);
		stringBuilder.append(buildImageFilePath(movieId));
		return stringBuilder.toString();
	}

	private String buildBasePath() {
		String path = String.format(CONFIGURATION_URL, this.apiKeyHandler.getApiKey());
		URL url = createUrl(path);
		JSONObject jsonResponse = JsonUtilities.getJsonResponse(url);
		return jsonResponse.getJSONObject("images").getString("base_url");
	}
	
	private String buildImageFilePath(int movieId) {
		String path = String.format(MOVIE_URL, movieId, this.apiKeyHandler.getApiKey());
		URL url = createUrl(path);
		return JsonUtilities.getJsonResponse(url).getString("backdrop_path");
	}
}

