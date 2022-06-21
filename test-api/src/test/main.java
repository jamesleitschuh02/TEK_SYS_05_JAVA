package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class main {

	private static HttpURLConnection connection;
	
	public static void main(String[] args) {
		// https://jsonplaceholder.typicode.com/albums
		
		//Method 1: java.net.httpURLConnection
		
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		
		try {
//			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=plymouth&appid=bf0a61546d9083e91b1a07813951c139&units=imperial");
			connection = (HttpURLConnection) url.openConnection();
			
			// Request Setup
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			
			// Check status, want 200
			int status = connection.getResponseCode();
			System.out.println(status);
			
			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
			}
			System.out.println(responseContent.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}
		
	}

}
