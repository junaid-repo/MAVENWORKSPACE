package com.example.javapractise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExternalTest {

	public static void main(String[] args) {

		Map<String, Object> response = new HashMap<>();
		Map<String, Object> map = new HashMap<>();

		String st1 = "{\"status\":true,\"message\":\"Success\",\"timestamp\":1667723068762,\"data\":[{\"train_number\":\"18621\",\"train_name\":\"Patliputra Exp\",\"train_type\":\"M\",\"run_days\":[\"Sun\",\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\"],\"train_origin_station\":\"Patna\",\"train_origin_station_code\":\"PNBE\",\"train_destination_station\":\"Hatia\",\"train_destination_station_code\":\"HTE\",\"depart_time\":\"16:03:00\",\"arrival_time\":\"04:25:00\",\"distance\":\"503\",\"class_type\":[\"3A\",\"SL\",\"2S\"],\"day_of_journey\":1},{\"train_number\":\"18623\",\"train_name\":\"Ipr Hatia Exp\",\"train_type\":\"M\",\"run_days\":[\"Sun\",\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\"],\"train_origin_station\":\"Islampur\",\"train_origin_station_code\":\"IPR\",\"train_destination_station\":\"Hatia\",\"train_destination_station_code\":\"HTE\",\"depart_time\":\"20:30:00\",\"arrival_time\":\"07:25:00\",\"distance\":\"428\",\"class_type\":[\"1A\",\"2A\",\"3A\",\"SL\",\"2S\"],\"day_of_journey\":1},{\"train_number\":\"18625\",\"train_name\":\"Prnc Hte Expres\",\"train_type\":\"M\",\"run_days\":[\"Sun\",\"Mon\",\"Tue\",\"Wed\",\"Thu\",\"Fri\",\"Sat\"],\"train_origin_station\":\"Purnia\",\"train_origin_station_code\":\"PRNC\",\"train_destination_station\":\"Hatia\",\"train_destination_station_code\":\"HTE\",\"depart_time\":\"09:39:00\",\"arrival_time\":\"20:30:00\",\"distance\":\"441\",\"class_type\":[\"2A\",\"3A\",\"CC\",\"SL\",\"2S\"],\"day_of_journey\":1}]}\r\n"
				+ "";
		ObjectMapper mapper = new ObjectMapper();
		try {

			// convert JSON string to Map
			map = mapper.readValue(st1, Map.class);
			// System.out.println(map.get("status"));
			// System.out.println(map.get("message"));
			// it works
			// Map<String, String> map = mapper.readValue(json, new
			// TypeReference<Map<String, String>>() {});

			// System.out.println(map);

		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Object> ar = new ArrayList<>();
		map.remove("run_days");
		map.remove("class_type");
		ar = (List<Object>) map.get("data");

		// System.out.println(ar);

		for (Object ar1 : ar) {
			// System.out.println(ar1);

			StringBuffer st4 = new StringBuffer(ar1.toString());

			st4.replace(ar1.toString().length() - 1, ar1.toString().length(), "");
			st4.replace(0, 1, "");
			// System.out.println(st4);

			for (String st3 : st4.toString().split(",")) {

				if (st3.contains("run_days") == false) {
					if (st3.contains("=") == true) {
						if (st3.contains("[") == false) {
							// System.out.println(st3.trim());

							String arr3[] = st3.trim().split("=");
							Map<String, String> retMap = new HashMap<>();
							retMap.put(arr3[0], arr3[1]);

							System.out.println(retMap);

							/*
							 * String st4[] = st3.split("="); if (st4[0]!=("run_days")) {
							 * 
							 * try { System.out.println(st4[0]+":"+st4[1]); } catch (Exception e) { // TODO
							 * Auto-generated catch block
							 * 
							 * } }
							 */
						}
					}
				}
				

			}
			System.out.println("####################################################################");
		}

	}
}
