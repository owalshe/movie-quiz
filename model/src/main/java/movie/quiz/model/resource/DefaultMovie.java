package movie.quiz.model.resource;

import movie.quiz.api.model.Movie;

public class DefaultMovie implements Movie {

	private Integer id;
	private String title;
	private String relaseYear;
	
	public DefaultMovie(Integer id, String title, String relaseYear) {
		this.id = id;
		this.title = title;
		this.relaseYear = relaseYear;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public String getRelaseYear() {
		return this.relaseYear;
	}
}
