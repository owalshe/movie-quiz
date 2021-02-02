package movie.rest.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import movie.quiz.api.model.Answer;
import movie.quiz.api.type.YearOfReleaseQuiz;
import movie.quiz.service.ApiKeyHandler;
import movie.quiz.service.DefaultMovieQuizService;
import movie.quiz.service.factory.DefaultMovieFactory;
import movie.quiz.service.resource.MovieImageResource;
import movie.quiz.service.resource.MovieResource;
import movie.quiz.service.resource.RandomMovieResource;
import movie.quiz.service.type.DefaultYearOfReleaseQuizFactory;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DefaultMovieQuizService.class, DefaultYearOfReleaseQuizFactory.class, DefaultMovieFactory.class,
		ApiKeyHandler.class, MovieResource.class, RandomMovieResource.class, MovieImageResource.class})
class DefaultMovieQuizServiceTest {

	@Autowired
	private DefaultMovieQuizService quizService;
	
	@Test
	void testCreateQuiz() throws Exception {
		YearOfReleaseQuiz quiz = this.quizService.createYearOfReleaseQuiz();
		assertNotNull(quiz);
	}
	
	@Test
	void testSolveQuiz() throws Exception {
		Answer result = this.quizService.answerYearOfReleaseQuiz(8872, "1992");
		assertTrue(result.isCorrect());
	}
}
