package movie.quiz.model.resource;

import movie.quiz.api.model.Image;

public class DefaultImage implements Image {

	private final String path;

	public DefaultImage(String imagePath) {
		this.path = imagePath;
	}

	@Override
	public String getPath() {
		return this.path;
	}
}
