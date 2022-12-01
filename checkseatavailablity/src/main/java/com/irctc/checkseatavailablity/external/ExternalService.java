package com.irctc.checkseatavailablity.external;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

import com.jdbcdemo.jdbcdemo.properties.AppProperties;


@Component
public class ExternalService {

	public String checkSeatAvailability(String classType, String fromStation, String quota, String toStation,
			String trainNumber, String date) {
		/*
		 * HttpResponse<String> response = null; HttpRequest request =
		 * HttpRequest.newBuilder().uri(URI.create(
		 * "https://irctc1.p.rapidapi.com/api/v1/checkSeatAvailability?classType="+
		 * classType+"&fromStationCode="+fromStation+"&quota="+quota+"&toStationCode="+
		 * toStation+"&trainNo="+trainNumber+"&date="+date)) .header("X-RapidAPI-Key",
		 * "1a05818094mshaeae5bbb1e2604dp153414jsn8fad5fb302a1")
		 * .header("X-RapidAPI-Host", "irctc1.p.rapidapi.com").method("GET",
		 * HttpRequest.BodyPublishers.noBody()) .build();
		 * 
		 * try { response = HttpClient.newHttpClient().send(request,
		 * HttpResponse.BodyHandlers.ofString()); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (InterruptedException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		//System.out.println(response.body());
		return "{\r\n"
				+ "  \"status\": true,\r\n"
				+ "  \"message\": \"Success\",\r\n"
				+ "  \"timestamp\": 1667739845077,\r\n"
				+ "  \"data\": [\r\n"
				+ "    {\r\n"
				+ "      \"total_fare\": 272,\r\n"
				+ "      \"date\": \"25-11-2022\",\r\n"
				+ "      \"current_status\": \"AVAILABLE-0176...\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"total_fare\": 272,\r\n"
				+ "      \"date\": \"26-11-2022\",\r\n"
				+ "      \"current_status\": \"AVAILABLE-0076...\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"total_fare\": 272,\r\n"
				+ "      \"date\": \"27-11-2022\",\r\n"
				+ "      \"current_status\": \"RAC  44/RAC  43...\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"total_fare\": 272,\r\n"
				+ "      \"date\": \"28-11-2022\",\r\n"
				+ "      \"current_status\": \"AVAILABLE-0193...\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"total_fare\": 272,\r\n"
				+ "      \"date\": \"29-11-2022\",\r\n"
				+ "      \"current_status\": \"AVAILABLE-0238...\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"total_fare\": 272,\r\n"
				+ "      \"date\": \"30-11-2022\",\r\n"
				+ "      \"current_status\": \"AVAILABLE-0169...\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}

}
