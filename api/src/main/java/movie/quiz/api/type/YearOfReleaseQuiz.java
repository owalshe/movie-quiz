package movie.quiz.api.type;

import java.util.List;

public interface YearOfReleaseQuiz {

	int getId();

	String getName();

	String getImagePath();

	List<Integer> getChoices();

}
