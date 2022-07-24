package com.demo.ExcelProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Java Program to parse and read CSV file using traditional BufferedReader
 * approach and by using more functional CSV parser from Apache Commons CSV
 * library. Apache Commons CSV support different CSV format including default
 * one, with or without header, reading EXCEL or XLS CSV file etc.
 *
 * @author
 */
public class CSVReader {

	public  String csvRead(String location) throws FileNotFoundException, IOException {

		System.out.println("Parsing CSV file using CSVParser of Apache commons CSV");
		//String location = "C:\\\\Users\\\\junai\\\\Downloads\\\\BulkEmployees.csv";
		List<Map> ar = new ArrayList<>();
		ar = parseCSV(location);
		// System.out.println(ar);
		String mapString = "";
		String resturnString = "";

		for (Map tempMap : ar) {
			// System.out.println(tempMap);
			ObjectMapper mapper = new ObjectMapper();
			String empJson = mapper.writeValueAsString(tempMap);

			// Print JSON output
			mapString =  empJson + ",";
			resturnString=resturnString+mapString;
		}
		//System.out.println(resturnString);
		StringBuilder sb = new StringBuilder(resturnString);
		sb.deleteCharAt(resturnString.length()-1);
		StringBuffer stringBuffer = new StringBuffer(sb);
		stringBuffer.insert(0, "[");
		stringBuffer.insert(resturnString.length(), "]");
		return stringBuffer.toString();

	}

	/*
	 * Java program to read CVS file using BufferedReader and String split() method
	 */

	/*
	 * Method to read CSV file using CSVParser from Apache Commons CSV
	 */
	public static List<Map> parseCSV(String fileLocation) throws FileNotFoundException, IOException {
		CSVParser parser = new CSVParser(new FileReader(fileLocation), CSVFormat.DEFAULT.withHeader());
		String st1 = parser.getHeaderMap().toString();
		StringBuilder sb = new StringBuilder(st1);
		List<String> paramList = new ArrayList<>();
		sb.deleteCharAt(st1.length() - 1);
		sb.deleteCharAt(0);
		List<Map> response = new ArrayList<>();
		String responseString = "";

		// System.out.println(sb);
		// st1 = parser.getHeaderMap().toString().replaceAll("}", "");

		String ar[] = sb.toString().split(",");
		for (int i = 0; i < ar.length; i++) {
			String tempString = ar[i].trim();
			// System.out.println(tempString);
			String paramName = "";
			for (int j = 0; j < tempString.length(); j++) {

				if (tempString.charAt(j) == '=') {
					break;
				}
				paramName = paramName + tempString.charAt(j);

			}
			paramList.add(paramName);

		}

		for (CSVRecord record : parser) {
			Map<String, String> retMap = new HashMap<>();
			for (String params : paramList) {
				// System.out.print(record.get(params).toString() + " ");

				responseString = record.get(params).toString() + " ";
				retMap.put(params, responseString.trim());

			}
			response.add(retMap);
		}

		parser.close();
		return response;
	}

}
