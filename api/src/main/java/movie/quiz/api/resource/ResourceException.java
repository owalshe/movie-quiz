package movie.quiz.api.resource;

@SuppressWarnings("serial")
public class ResourceException extends Exception {

	public ResourceException(String msg, Throwable e) {
		super(msg, e);
	}
}
