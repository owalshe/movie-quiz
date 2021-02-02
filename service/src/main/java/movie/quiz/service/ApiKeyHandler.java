package movie.quiz.service;

import org.springframework.stereotype.Component;

@Component
public class ApiKeyHandler {

	private static final String API_KEY = "7d6279bf53ff36ebb745cf25b4f01791";
	
	public ApiKeyHandler() {}
	
	public String getApiKey() {
		return API_KEY;
	}
}
