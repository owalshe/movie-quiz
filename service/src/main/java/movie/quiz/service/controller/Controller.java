package movie.quiz.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import movie.quiz.api.model.Answer;
import movie.quiz.api.service.MovieQuizService;
import movie.quiz.api.type.YearOfReleaseQuiz;

@RestController
public class Controller {

	@Autowired
	private MovieQuizService quizService;
	
	@GetMapping("/year-of-release-quiz")
	public YearOfReleaseQuiz movie() throws Exception {
		return this.quizService.createYearOfReleaseQuiz();
	}
	
	@GetMapping("/answer-year-of-release-quiz")
	public Answer movie(@RequestParam(value = "movieId") int movieId, 
			@RequestParam(value = "year") String year) throws Exception {
		return this.quizService.answerYearOfReleaseQuiz(movieId, year);
	}
}
