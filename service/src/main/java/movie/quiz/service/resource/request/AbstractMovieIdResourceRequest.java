package movie.quiz.service.resource.request;

import movie.quiz.api.resource.ResourceRequest;

public class AbstractMovieIdResourceRequest implements ResourceRequest {

	private int movieId;
	
	public AbstractMovieIdResourceRequest(int movieId) {
		this.movieId = movieId;
	}

	public int getMovieId() {
		return movieId;
	}
}
