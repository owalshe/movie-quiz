package movie.rest.service.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;

import movie.quiz.service.type.YearOfReleaseQuizChoiceBuilder;

class QuizChoiceBuilderTest {

	private static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	private static final int INCREMENT = 2;
	private static final int NUMBER_OF_CHOICES = 4;
	
	@Test
	void testPastYear() {
		int year = 2000;
		YearOfReleaseQuizChoiceBuilder builder = new YearOfReleaseQuizChoiceBuilder(NUMBER_OF_CHOICES, INCREMENT);
		List<Integer> choices = builder.build(year);
		assertEquals(NUMBER_OF_CHOICES, choices.size());
		assertTrue(choices.contains(year));
	}
	
	@Test
	void testCurrentYear() {
		YearOfReleaseQuizChoiceBuilder builder = new YearOfReleaseQuizChoiceBuilder(NUMBER_OF_CHOICES, INCREMENT);
		List<Integer> choices = builder.build(CURRENT_YEAR);
		assertEquals(NUMBER_OF_CHOICES, choices.size());
		assertTrue(choices.contains(CURRENT_YEAR));
	}
	
	@Test
	void testLastYear() {
		int year = CURRENT_YEAR-1;
		YearOfReleaseQuizChoiceBuilder builder = new YearOfReleaseQuizChoiceBuilder(NUMBER_OF_CHOICES, INCREMENT);
		List<Integer> choices = builder.build(year);
		assertEquals(NUMBER_OF_CHOICES, choices.size());
		assertTrue(choices.contains(year));
	}
	
	@Test
	void testRecentYear() {
		int year = CURRENT_YEAR - INCREMENT -1;
		YearOfReleaseQuizChoiceBuilder builder = new YearOfReleaseQuizChoiceBuilder(NUMBER_OF_CHOICES, INCREMENT);
		List<Integer> choices = builder.build(year);
		assertEquals(NUMBER_OF_CHOICES, choices.size());
		assertTrue(choices.contains(year));
	}
}
