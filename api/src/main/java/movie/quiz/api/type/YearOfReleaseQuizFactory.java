package movie.quiz.api.type;

import movie.quiz.api.model.Answer;
import movie.quiz.api.resource.ResourceException;

public interface YearOfReleaseQuizFactory {

	YearOfReleaseQuiz create() throws ResourceException;

	Answer answer(int movieId, String year) throws ResourceException;

}
