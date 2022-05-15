package test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;

public class main {

	public static void main(String[] args) {
		
		// Method 2: java.net.http.HttpClient
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/albums")).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			.thenApply(HttpResponse::body)
			.thenAccept(System.out::println)
			.join();
		
		// MUST ADD JAR FILE TO PARSE DATA
		// parse json data
		
		
	}
	
	public static String parse(String responseBody) {
		JSONArray albums = new JSONArray(responseBody);
	}

}
