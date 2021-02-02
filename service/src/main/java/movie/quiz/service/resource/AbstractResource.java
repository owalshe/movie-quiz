package movie.quiz.service.resource;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractResource {

	protected URL createUrl(String path) {
		try {
			return new URL(path);
		} catch (MalformedURLException e) {
			String msg = String.format("Unable to create url for path: %s", path);
			throw new IllegalStateException(msg, e);
		}
	}
}
