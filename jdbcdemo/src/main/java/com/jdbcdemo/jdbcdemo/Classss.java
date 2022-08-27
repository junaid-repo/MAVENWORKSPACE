package com.jdbcdemo.jdbcdemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.jdbcdemo.service.CoreServiceCall;
import com.jdbcdemo.jdbcdemo.dto.BaseOutput;

public class Classss {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		String fileLocation = "C:\\\\Users\\\\junai\\\\Downloads\\\\REVENUE_2.csv";
		CSVParser parser = new CSVParser(new FileReader(fileLocation), CSVFormat.DEFAULT.withHeader());

		// createTable2(tableName, fileLocation);
		Map<String, Integer> retMap = parser.getHeaderMap();

		List<CSVRecord> retMap3 = parser.getRecords();

		String response = "Success";

		// System.out.println(retMap3.get(1));
		// CSVRecord st = retMap3.get(0).get(null);

		// System.out.println(retMap3);
		// System.out.println(retMap3.get(0));
		// testCSV();

		Map<Integer, String> retMap2 = new HashMap<>();
		// System.out.println(retMap);
		String columnNames = "";
		String columnNames2 = "";
		// System.out.println(retMap.size());

		Map<Integer, String> myNewHashMap = new HashMap<>();
		for (Map.Entry<String, Integer> entry : retMap.entrySet()) {
			myNewHashMap.put(entry.getValue(), entry.getKey());
		}
		ArrayList<String> arList = new ArrayList<>();
		// System.out.println(myNewHashMap);
		for (int i = 0; i < myNewHashMap.size(); i++) {
			columnNames = myNewHashMap.get(i);
			// System.out.println(response);
			// retMap2.put(retMap.get, response)
			arList.add(columnNames.trim());
		}
		// columnNames = columnNames.substring(0, columnNames.length() - 2);
		columnNames = columnNames.replace(' ', '_');
		// System.out.println(columnNames);

		BufferedReader br = null;

		String line = "";

		int count = 0;
		// List<String> list = new ArrayList<String>();
		String secondRow = "";
		br = new BufferedReader(new FileReader(fileLocation));
		boolean firstLine = true;
		while ((line = br.readLine()) != null) {
			count++;
			if (count == 2) {

				secondRow = line;
				break;
			}
		}
		String secondRowArray[] = secondRow.split(",");
		List<String> secondRowList = new ArrayList<>();
		for (int j = 0; j < secondRowArray.length; j++) {
			secondRowList.add(secondRowArray[j]);
		}
		System.out.println(arList);
		System.out.println(secondRowList);

		Iterator<String> it1 = arList.iterator();
		String finalRows = "";
		// Iterator<String> it2 = list.iterator();
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < arList.size(); i++) {
			str1 = arList.get(i);
			str2 = secondRowList.get(i);
			finalRows =finalRows+ str1 + "~~" + str2 + "##";
			// do stuff
		}
		finalRows = finalRows.substring(0, finalRows.length() - 2);
		System.out.println(finalRows);
		
		


		StringBuilder sb = null;
	//	BaseOutput response = new BaseOutput();
		int count2 = 0;
		int i;
		// Reader reader =
		// Files.newBufferedReader(Paths.get("C:/Users/junai/Downloads/Document3.csv"));
		try {
			Reader in = new FileReader(fileLocation);
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			for (CSVRecord record : records) {
				String values = "";
				if (count2 > 1) {
					for (i = 0; i < record.size() - 1; i++) {
						
						if(secondRowList.get(i).equals("DATE")) {
							String tempDate="to_date(@@"+record.get(i)+"@@, @@dd-mm-rrrr HH24:MI:SS@@)"+"~~";
							values = values + tempDate +secondRowList.get(i) + "##";
						}
						else
							values = values + record.get(i)+"~~"+secondRowList.get(i) + "##";
					}
					/*
					 * values = values.replace('\@@, ' '); values = values.replace('(', ' '); values
					 * = values.replace(')', ' '); values = values.replace(',', ' '); values =
					 * values.replace('/', ' ');
					 */
					// values=values.replace('-', ' ');
					// values=values.replace('#', ' ');
					if (i == record.size() - 1) {
						values = values + record.get(i)+"~~"+secondRowList.get(i);
					}
					sb = new StringBuilder(values);
					// sb.deleteCharAt(values.length() - 3);
					System.out.println(sb);
				}
				count2++;
				
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	return response;
	

		
	}

}
