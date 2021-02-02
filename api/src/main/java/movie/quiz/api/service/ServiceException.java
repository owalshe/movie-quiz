package movie.quiz.api.service;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException(String msg, Throwable e) {
		super(msg, e);
	}
}
