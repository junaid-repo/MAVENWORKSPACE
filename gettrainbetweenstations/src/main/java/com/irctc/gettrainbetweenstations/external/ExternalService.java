package com.irctc.gettrainbetweenstations.external;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

import com.jdbcdemo.jdbcdemo.properties.AppProperties;


@Component
public class ExternalService {
	
	public String getTrainBetweenStations(String from, String to) {
		
		
		
		/*
		 * String URIToHit="";
		 * 
		 * HttpRequest request = HttpRequest.newBuilder() .uri(URI.create(
		 * "https://irctc1.p.rapidapi.com/api/v2/trainBetweenStations?fromStationCode="+
		 * from+"&toStationCode="+to)) .header("X-RapidAPI-Key",
		 * "ec006851b0mshb00e264fb95e9cap181e4ajsna56a1113b969")
		 * .header("X-RapidAPI-Host", "irctc1.p.rapidapi.com") .method("GET",
		 * HttpRequest.BodyPublishers.noBody()) .build(); HttpResponse<String>
		 * response=null;
		 * 
		 * try { response = HttpClient.newHttpClient().send(request,
		 * HttpResponse.BodyHandlers.ofString()); System.out.println(response.body()); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		//System.out.println(Utility.insertApiLogs(AppProperties.rapidAPITranslateURI, "", response.body()));
		
		
		return "{\"status\":true,\"message\":\"Success\",\"timestamp\":1667735780870,\"data\":[{\"train_number\":\"18626\",\"train_name\":\"Hte Prnc Exp\",\"train_type\":\"M\",\"run_days\":[\"Sun\",\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\"],\"train_origin_station\":\"Hatia\",\"train_origin_station_code\":\"HTE\",\"train_destination_station\":\"Purnia\",\"train_destination_station_code\":\"PRNC\",\"depart_time\":\"06:20:00\",\"arrival_time\":\"16:26:00\",\"distance\":\"437\",\"class_type\":[\"2A\",\"3A\",\"CC\",\"SL\"],\"day_of_journey\":1},{\"train_number\":\"18624\",\"train_name\":\"Hte Ipr Exp\",\"train_type\":\"M\",\"run_days\":[\"Sun\",\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\"],\"train_origin_station\":\"Hatia\",\"train_origin_station_code\":\"HTE\",\"train_destination_station\":\"Islampur\",\"train_destination_station_code\":\"IPR\",\"depart_time\":\"19:50:00\",\"arrival_time\":\"07:08:00\",\"distance\":\"429\",\"class_type\":[\"1A\",\"2A\",\"3A\",\"SL\"],\"day_of_journey\":1},{\"train_number\":\"18622\",\"train_name\":\"Pataliputra Exp\",\"train_type\":\"M\",\"run_days\":[\"Sun\",\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\"],\"train_origin_station\":\"Hatia\",\"train_origin_station_code\":\"HTE\",\"train_destination_station\":\"Patna\",\"train_destination_station_code\":\"PNBE\",\"depart_time\":\"22:35:00\",\"arrival_time\":\"11:22:00\",\"distance\":\"501\",\"class_type\":[\"3A\",\"SL\"],\"day_of_journey\":1}]}\r\n"
				+ "";
	}

}
