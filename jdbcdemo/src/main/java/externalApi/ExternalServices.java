package externalApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jdbcdemo.jdbcdemo.properties.AppProperties;

public class ExternalServices {

	// private final RestTemplate restTemplate;

	/*
	 * public ServiceLayer(RestTemplate restTemplate) {
	 * 
	 * this.restTemplate = restTemplate; }
	 */

	public String translateText(String text, String fromLang, String toLang) {
		
		String translatedText = "";
		String body = "q="+text+"&target="+toLang+"&"+fromLang;
		System.out.println(body);

		try {
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(AppProperties.rapidAPITranslateURI))
					.header("content-type", "application/x-www-form-urlencoded")
					.header("Accept-Encoding", "application/gzip").header("X-RapidAPI-Key", AppProperties.rapidAPIKey)
					.header("X-RapidAPI-Host", AppProperties.rapidAPITranlateHost)
					.method("POST", HttpRequest.BodyPublishers.ofString(body))
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			translatedText = response.body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return translatedText;
	}

	public String consumeAPI() {
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.getForObject("https://reqres.in/api/users?page=2", String.class);
	}

	{
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://weatherapi-com.p.rapidapi.com/future.json?q=London&dt=2022-12-25"))
					.header("X-RapidAPI-Key", "ec006851b0mshb00e264fb95e9cap181e4ajsna56a1113b969")
					.header("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody()).build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}