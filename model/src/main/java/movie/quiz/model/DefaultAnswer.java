package movie.quiz.model;

import movie.quiz.api.model.Answer;

public class DefaultAnswer implements Answer {

	private boolean isCorrect;
	
	public DefaultAnswer(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public boolean isCorrect() {
		return isCorrect;
	}
}
