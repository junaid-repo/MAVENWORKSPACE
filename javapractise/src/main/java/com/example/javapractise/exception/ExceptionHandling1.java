package com.example.javapractise.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExceptionHandling1 {

	public static void main(String[] args) {

		String megaData = "##Hi AA, how are you~~10-JAN-23~~Saima Aftab##I am fine. How bout you?~~10-JAN-23~~Nemat Fatima##Enjoying my life~~10-JAN-23~~Saima Aftab##So.. where do you live these days?~~10-JAN-23~~Nemat Fatima##I am in Ohiao.. And you?~~10-JAN-23~~Saima Aftab##I am in new mexico~~10-JAN-23~~Nemat Fatima";

		List<Map> listOfMaps = new ArrayList<>();

		String megaDataArr[] = megaData.split("@@");
		for (int i = 0; i < megaDataArr.length; i++) {

			String dataArr[] = megaDataArr[i].split("##");

			Map<String, String> retMap = new HashMap<>();
			for (int j = 1; j < dataArr.length; j++) {

				String arr[] = dataArr[j].split("~~");

				if (arr[0] != null && arr[1] != null)

					retMap.put(arr[0], arr[1]);

			}
			listOfMaps.add(retMap);

		}

		System.out.println(listOfMaps);
	}
}