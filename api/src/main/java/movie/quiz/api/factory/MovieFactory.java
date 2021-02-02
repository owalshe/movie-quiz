package movie.quiz.api.factory;

import movie.quiz.api.model.Image;
import movie.quiz.api.model.Movie;
import movie.quiz.api.resource.ResourceException;

public interface MovieFactory {

	Movie getMovie(int movieId) throws ResourceException;
	
	Movie getRandomMovie() throws ResourceException;
	
	Image getImage(int movieId) throws ResourceException;
}
