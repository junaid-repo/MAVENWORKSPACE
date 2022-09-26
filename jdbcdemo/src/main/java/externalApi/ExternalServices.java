package externalApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jdbcdemo.jdbcdemo.properties.AppProperties;

import utility.Utility;

public class ExternalServices {

	// private final RestTemplate restTemplate;

	/*
	 * public ServiceLayer(RestTemplate restTemplate) {
	 * 
	 * this.restTemplate = restTemplate; }
	 */

	public String translateText(String text, String fromLang, String toLang) {

		String translatedText = "";
		String body = "q=" + text + "&target=" + toLang + "&" + fromLang;
		System.out.println(body);

		try {
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(AppProperties.rapidAPITranslateURI))
					.header("content-type", "application/x-www-form-urlencoded")
					.header("Accept-Encoding", "application/gzip").header("X-RapidAPI-Key", AppProperties.rapidAPIKey)
					.header("X-RapidAPI-Host", AppProperties.rapidAPITranlateHost)
					.method("POST", HttpRequest.BodyPublishers.ofString(body)).build();
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
		System.out.println(Utility.insertApiLogs(AppProperties.rapidAPITranslateURI, body, translatedText));
		return translatedText;
	}

	public String sendSimpleMail(String message, String subject, String from, String to) {

		from = Utility.convertSingleStringToJsonType(from);
		to = Utility.convertSingleStringToJsonType(to);
		subject = Utility.convertSingleStringToJsonType(subject);
		message = Utility.convertSingleStringToJsonType(message);

		String masterMessage = "{\"personalizations\": [{\"to\": [{\"email\": " + to + "}],\"subject\": " + subject
				+ "}],\"from\": {\"email\": " + from + "},\"content\": [{\"type\": \"text/plain\",\"value\": " + message
				+ "}]}\n" + "";
		System.out.println(masterMessage);
		try {
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(AppProperties.sendGridSimpleMailURI))
					.header("content-type", "application/json").header("X-RapidAPI-Key", AppProperties.rapidAPIKey)
					.header("X-RapidAPI-Host", AppProperties.sendGridSimpleMailHost)
					.method("POST", HttpRequest.BodyPublishers.ofString(masterMessage)).build();
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
		System.out.println(Utility.insertApiLogs(AppProperties.sendGridSimpleMailURI, masterMessage, ""));
		return "Success!!!";
	}

	public static String getPinCodeDetails(String pinCode) {

		String input = "{\r\"searchBy\": \"pincode\",\r\"value\":" + pinCode + "\r}";

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(AppProperties.postOfficeDetails))
				.header("content-type", "application/json").header("Content-Type", "application/json")
				.header("X-RapidAPI-Key", AppProperties.postOfficeAPIKey)
				.header("X-RapidAPI-Host", "pincode.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString(input)).build();
		String toResponse = "";
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			toResponse = response.body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Utility.insertApiLogs(AppProperties.postOfficeDetails, pinCode, toResponse));
		return toResponse;
	}

	public static String getTrainDetails(String trainNumber) {

		trainNumber="\""+trainNumber+"\"";
		
		String requestJson = "{\r\"search\":" + trainNumber + "\r}";
		String requestJson2 = "{\r\"search\": \"Rajdhani\"\r}";

		/*
		 * HttpRequest request2 =
		 * HttpRequest.newBuilder().uri(URI.create(AppProperties.trainDetailsURI))
		 * .header("content-type", "application/json").header("X-RapidAPI-Key",
		 * AppProperties.trainDetailsAPIKey) .header("X-RapidAPI-Host",
		 * "trains.p.rapidapi.com") .method("POST",
		 * HttpRequest.BodyPublishers.ofString(requestJson)).build();
		 */

		HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(AppProperties.trainDetailsURI))
				.header("content-type", "application/json").header("X-RapidAPI-Key", AppProperties.trainDetailsAPIKey)
				.header("X-RapidAPI-Host", "trains.p.rapidapi.com")
				.method("POST", HttpRequest.BodyPublishers.ofString(requestJson)).build();

		String toResponse = "";
		HttpResponse<String> response2;
		try {
			response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
			System.out.println(response2.body());
			toResponse = response2.body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Utility.insertApiLogs(AppProperties.trainDetailsURI, trainNumber, toResponse));
		return toResponse;
	}

}