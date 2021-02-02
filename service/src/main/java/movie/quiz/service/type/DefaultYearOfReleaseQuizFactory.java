package movie.quiz.service.type;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import movie.quiz.api.factory.MovieFactory;
import movie.quiz.api.model.Answer;
import movie.quiz.api.model.Image;
import movie.quiz.api.model.Movie;
import movie.quiz.api.resource.ResourceException;
import movie.quiz.api.type.YearOfReleaseQuiz;
import movie.quiz.api.type.YearOfReleaseQuizFactory;
import movie.quiz.model.DefaultAnswer;
import movie.quiz.model.type.DefaultYearOfReleaseQuiz;

@Component
public class DefaultYearOfReleaseQuizFactory implements YearOfReleaseQuizFactory {

	@Autowired
	private MovieFactory movieFactory;
	private YearOfReleaseQuizChoiceBuilder quizChoiceBuilder = new YearOfReleaseQuizChoiceBuilder(3, 3);
	
	@Override
	public YearOfReleaseQuiz create() throws ResourceException {
		Movie movie = this.movieFactory.getRandomMovie();
        Integer movieId = movie.getId();
        Image image = this.movieFactory.getImage(movieId);
        List<Integer> choices = getChoices(movie.getRelaseYear());
        return new DefaultYearOfReleaseQuiz(image.getPath(), movieId.intValue(), movie.getTitle(), 
        		movie.getRelaseYear(), choices);
	}
	
	@Override
	public Answer answer(int movieId, String year) throws ResourceException {
		Movie movie = movieFactory.getMovie(movieId);
		return new DefaultAnswer(movie.getRelaseYear().equals(year));
	}
	
	private List<Integer> getChoices(String relaseYear) {
		return this.quizChoiceBuilder.build(Integer.valueOf(relaseYear));
	}


}
