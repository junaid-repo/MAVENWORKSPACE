package com.irctc.getfair.external;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

@Component
public class ExternalService {

	public String getTrainFair(String trainNumber, String fromStation, String toStation) {
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
		// System.out.println(response.body());
		return "{\r\n" + "    \"status\": true,\r\n" + "    \"message\": \"Success\",\r\n"
				+ "    \"timestamp\": 1667743596615,\r\n" + "    \"data\": [\r\n" + "        {\r\n"
				+ "            \"classType\": \"CC\",\r\n" + "            \"fare\": 580\r\n" + "        },\r\n"
				+ "        {\r\n" + "            \"classType\": \"3A\",\r\n" + "            \"fare\": 720\r\n"
				+ "        },\r\n" + "        {\r\n" + "            \"classType\": \"2A\",\r\n"
				+ "            \"fare\": 1020\r\n" + "        },\r\n" + "        {\r\n"
				+ "            \"classType\": \"SL\",\r\n" + "            \"fare\": 265\r\n" + "        }\r\n"
				+ "    ]\r\n" + "}";
	}

}
