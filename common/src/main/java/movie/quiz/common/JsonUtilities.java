package movie.quiz.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class JsonUtilities {

	public static JSONObject getJsonResponse(URL url) {
		try {
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	        if (conn.getResponseCode() != 200) {
	            throw new IllegalStateException("HTTP Request Failed : Error code : " + conn.getResponseCode());
	        }
	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
				StringBuilder content = new StringBuilder();
				String inputLine;
				while ((inputLine = reader.readLine()) != null) {
				    content.append(inputLine);
				}
				return new JSONObject(content.toString());
	        } 
		} catch (Exception e) {
			String msg = "Unable to get response";
			throw new IllegalStateException(msg, e);
		}
	}
}
