package movie.quiz.api.service;

import movie.quiz.api.model.Answer;
import movie.quiz.api.type.YearOfReleaseQuiz;

public interface MovieQuizService {

	YearOfReleaseQuiz createYearOfReleaseQuiz() throws ServiceException;

	Answer answerYearOfReleaseQuiz(int movieId, String year) throws ServiceException;

}
