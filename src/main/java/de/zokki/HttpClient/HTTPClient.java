package de.zokki.HttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

import de.zokki.HttpClient.Logger.Logger;

public class HTTPClient {

	private final Logger LOGGER = new Logger(HTTPClient.class, false);
	
	public static void main(String[] args) {
		new HTTPClient();
	}
	
	public HTTPClient() {
		LOGGER.info("Client starting...");
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = null;
		
		try {
			request = HttpRequest.newBuilder(URI.create("http://localhost:8080/test"))
				      .POST(BodyPublishers.ofFile(Paths.get("src/main/resources/http.json")))
				      .build();
			HttpResponse<String> s = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(s.statusCode());
			System.out.println(s.body());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
