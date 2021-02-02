package movie.quiz.model.type;

import java.util.List;

import movie.quiz.api.type.YearOfReleaseQuiz;

public class DefaultYearOfReleaseQuiz implements YearOfReleaseQuiz {

	private String imagePath;
	private int id;
	private String name;
	private String release;
	private List<Integer> choices;
	
	public DefaultYearOfReleaseQuiz(String imagePath, int id, String name, String release, List<Integer> choices) {
		this.id = id;
		this.name = name;
		this.imagePath = imagePath;
		this.release = release;
		this.choices = choices;
	}

	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getImagePath() {
		return imagePath;
	}

	@Override
	public String getYear() {
		return release;
	}

	public List<Integer> getChoices() {
		return choices;
	}
}
