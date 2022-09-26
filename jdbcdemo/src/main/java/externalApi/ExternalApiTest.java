package externalApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExternalApiTest {

	public static void main(String[] args) {
		/*
		 * HttpRequest request =
		 * HttpRequest.newBuilder().uri(URI.create("https://pincode.p.rapidapi.com/"))
		 * .header("content-type", "application/json").header("Content-Type",
		 * "application/json") .header("X-RapidAPI-Key",
		 * "ec006851b0mshb00e264fb95e9cap181e4ajsna56a1113b969")
		 * .header("X-RapidAPI-Host", "pincode.p.rapidapi.com") .method("POST",
		 * HttpRequest.BodyPublishers.
		 * ofString("{\r\"searchBy\": \"pincode\",\r\"value\": 700001\r}")) .build();
		 * 
		 * HttpResponse<String> response; try { response =
		 * HttpClient.newHttpClient().send(request,
		 * HttpResponse.BodyHandlers.ofString()); System.out.println(response.body()); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create("https://trains.p.rapidapi.com/"))
				.header("content-type", "application/json")
				.header("X-RapidAPI-Key", "ec006851b0mshb00e264fb95e9cap181e4ajsna56a1113b969")
				.header("X-RapidAPI-Host", "trains.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString("{\r\"search\": \"18626\"\r}")).build();
		HttpResponse<String> response2;
		try {
			response2 = HttpClient.newHttpClient().send(request2,
					HttpResponse.BodyHandlers.ofString());
			System.out.println(response2.body());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}