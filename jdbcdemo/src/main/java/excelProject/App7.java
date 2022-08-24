package excelProject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.jdbcdemo.jdbcdemo.coreCall.CoreServiceCall;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsRequest;
import com.jdbcdemo.jdbcdemo.dto.Property;
import com.jdbcdemo.jdbcdemo.properties.AppProperties;

/**
 * Hello world!
 *
 */
public class App7 {
	EmployeeDetailsRequest emp = new EmployeeDetailsRequest();

	public static void main(String[] args) {

		String from = "\"eidPartyGroup@gmail.com\"";
		String to = "\"kingjunaid3001@gmail.com\"";
		String subject = "\"Just Checking\"";
		String message = "\"Its a test email. If it is readable in the mailbox then awesome\"\n" + "";

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
	}

}
