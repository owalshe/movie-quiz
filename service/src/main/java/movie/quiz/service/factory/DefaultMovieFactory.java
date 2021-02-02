package movie.quiz.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movie.quiz.api.factory.MovieFactory;
import movie.quiz.api.model.Image;
import movie.quiz.api.model.Movie;
import movie.quiz.api.resource.ResourceException;
import movie.quiz.service.resource.MovieImageResource;
import movie.quiz.service.resource.MovieResource;
import movie.quiz.service.resource.RandomMovieResource;
import movie.quiz.service.resource.request.ImageResourceRequest;
import movie.quiz.service.resource.request.MovieResourceRequest;
import movie.quiz.service.resource.request.RandomMovieResourceRequest;

@Component
public class DefaultMovieFactory implements MovieFactory {
	
	@Autowired
	private MovieResource movieResource;
	
	@Autowired
	private RandomMovieResource randomMovieResource;
	
	@Autowired
	private MovieImageResource imagePathResource;
	
	@Override
	public Movie getMovie(int movieId) throws ResourceException {
		MovieResourceRequest request = new MovieResourceRequest(movieId);
		return this.movieResource.get(request);
	}
	
	@Override
	public Movie getRandomMovie() throws ResourceException {
		RandomMovieResourceRequest request = new RandomMovieResourceRequest();
		return this.randomMovieResource.get(request);
	}
	
	@Override
	public Image getImage(int movieId) throws ResourceException {
		ImageResourceRequest request = new ImageResourceRequest(movieId);
		return this.imagePathResource.get(request);
	}
}
