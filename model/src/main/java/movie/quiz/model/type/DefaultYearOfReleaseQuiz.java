package movie.quiz.model.type;

import java.util.List;

import movie.quiz.api.type.YearOfReleaseQuiz;

public class DefaultYearOfReleaseQuiz implements YearOfReleaseQuiz {

	private int id;
	private String name;
	private String imagePath;
	private List<Integer> choices;
	
	public DefaultYearOfReleaseQuiz(int id, String name, String imagePath, List<Integer> choices) {
		this.id = id;
		this.name = name;
		this.imagePath = imagePath;
		this.choices = choices;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public String getImagePath() {
		return this.imagePath;
	}

	@Override
	public List<Integer> getChoices() {
		return this.choices;
	}
}
