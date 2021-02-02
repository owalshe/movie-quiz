package movie.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.quiz.api.model.Answer;
import movie.quiz.api.service.MovieQuizService;
import movie.quiz.api.service.ServiceException;
import movie.quiz.api.type.YearOfReleaseQuiz;
import movie.quiz.api.type.YearOfReleaseQuizFactory;

@Service
public class DefaultMovieQuizService implements MovieQuizService {

	@Autowired
	private YearOfReleaseQuizFactory yearOfReleaseQuizFactory;
	
	@Override
	public YearOfReleaseQuiz createYearOfReleaseQuiz() throws ServiceException {
		try {
			return this.yearOfReleaseQuizFactory.create();
		} catch (Exception e) {
			String msg = "Unable to create quiz";
			throw new ServiceException(msg, e);
		}
	}

	@Override
	public Answer answerYearOfReleaseQuiz(int movieId, String year) throws ServiceException {
		try {
			return yearOfReleaseQuizFactory.answer(movieId, year);
		} catch (Exception e) {
			String msg = "Unable to get answer";
			throw new ServiceException(msg, e);
		}
	}

}
