package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jdbcdemo.SimpleController;
import com.jdbcdemo.service.CoreServiceCall;
import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;

import excelProject.ImportURL;

public class Utility implements Runnable {

	ImportURL newImportUrl = new ImportURL();

	public ImportURL setImportUrl(ImportURL importUrl) {
		newImportUrl = importUrl;
		return newImportUrl;

	}

	public String changeData(ArrayList<InsertEmployeeList> arrayData, String seperator, Object ob) {

		String stringData = "";
		String tempString = "";

		for (InsertEmployeeList empList : arrayData) {
			tempString = empList.getDepartmentId() + "$$" + empList.getCommisionPct();

		}

		return stringData;
	}

	public static BaseOutput createTable(String tableName, String fileLocation, String version)
			throws FileNotFoundException, IOException {

		CSVParser parser = new CSVParser(new FileReader(fileLocation), CSVFormat.DEFAULT.withHeader());

		Map<String, Integer> retMap = parser.getHeaderMap();

		List<CSVRecord> retMap3 = parser.getRecords();

		String response = "Success";
		BaseOutput output = new BaseOutput();

		// System.out.println(retMap3.get(1));
		// CSVRecord st = retMap3.get(0).get(null);

		// System.out.println(retMap3);
		// System.out.println(retMap3.get(0));
		// testCSV();

		Map<Integer, String> retMap2 = new HashMap<>();
		// System.out.println(retMap);
		String columnNames = "";
		// System.out.println(retMap.size());

		Map<Integer, String> myNewHashMap = new HashMap<>();
		for (Map.Entry<String, Integer> entry : retMap.entrySet()) {
			myNewHashMap.put(entry.getValue(), entry.getKey());
		}
		// System.out.println(myNewHashMap);
		for (int i = 0; i < myNewHashMap.size(); i++) {
			columnNames = columnNames + myNewHashMap.get(i) + "##";
			// System.out.println(response);
			// retMap2.put(retMap.get, response)
		}
		columnNames = columnNames.substring(0, columnNames.length() - 2);
		columnNames = columnNames.replace(' ', '_');
		System.out.println(columnNames);
		try {
			output = CoreServiceCall.createTable(tableName, columnNames, version);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;

	}

	public static BaseOutput createTableWithColumnType(String tableName, String fileLocation, String version)
			throws FileNotFoundException, IOException {

		CSVParser parser = new CSVParser(new FileReader(fileLocation), CSVFormat.DEFAULT.withHeader());

		Map<String, Integer> retMap = parser.getHeaderMap();

		List<CSVRecord> retMap3 = parser.getRecords();

		String response = "Success";
		BaseOutput output = new BaseOutput();

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
			columnNames = myNewHashMap.get(i).trim();
			// System.out.println(response);
			// retMap2.put(retMap.get, response)
			arList.add(columnNames.trim());
		}
		// columnNames = columnNames.substring(0, columnNames.length() - 2);
		columnNames = columnNames.replace(' ', '_');
		columnNames = columnNames.replace('-', '_');
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
			finalRows = finalRows + str1 + "~~" + str2 + "##";
			// do stuff
		}
		finalRows = finalRows.substring(0, finalRows.length() - 2);
		finalRows = finalRows.replace(' ', '_');
		finalRows = finalRows.replace('-', '_');

		try {
			output = CoreServiceCall.createTable(tableName, finalRows, version);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;

	}

	public BaseOutput insertDataInTable(String tableName, String location, String version) {

		StringBuilder sb = null;
		BaseOutput response = new BaseOutput();
		int count = 0;
		int i;
		// Reader reader =
		// Files.newBufferedReader(Paths.get("C:/Users/junai/Downloads/Document3.csv"));

		try {
			Reader in = new FileReader(location);
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			for (CSVRecord record : records) {
				String values = "";
				if (count > 1) {
					for (i = 0; i < record.size() - 1; i++) {
						values = values + record.get(i) + "~~";
					}
					values = values.replace('\'', ' ');
					values = values.replace('(', ' ');
					values = values.replace(')', ' ');
					values = values.replace(',', ' ');
					values = values.replace('/', ' ');
					// values=values.replace('-', ' ');
					// values=values.replace('#', ' ');
					if (i == record.size() - 1) {
						values = values + record.get(i);
					}
					sb = new StringBuilder(values);
					// sb.deleteCharAt(values.length() - 3);

				}

				System.out.println(sb);
				if (count > 1) {
					try {
						CoreServiceCall csc = new CoreServiceCall();
						response = csc.insertDataInTable(tableName, sb.toString(), version);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				count++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	public BaseOutput insertDataInTable_WithColoumnName(String tableName, String fileLocation, String version)
			throws FileNotFoundException, IOException {

		// String fileLocation = "C:\\\\Users\\\\junai\\\\Downloads\\\\REVENUE_2.csv";
		CSVParser parser = new CSVParser(new FileReader(fileLocation), CSVFormat.DEFAULT.withHeader());

		// createTable2(tableName, fileLocation);
		Map<String, Integer> retMap = parser.getHeaderMap();

		List<CSVRecord> retMap3 = parser.getRecords();

		BaseOutput response = new BaseOutput();

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
			finalRows = finalRows + str1 + "~~" + str2 + "##";
			// do stuff
		}
		finalRows = finalRows.substring(0, finalRows.length() - 2);
		System.out.println(finalRows);

		StringBuilder sb = null;
		// BaseOutput response = new BaseOutput();
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

						if (secondRowList.get(i).equals("DATE")) {
							String tempDate = "to_date(@@" + record.get(i) + "@@, @@dd-mm-rrrr HH24:MI:SS@@)" + "~~";
							values = values + tempDate + secondRowList.get(i) + "##";
						} else
							values = values + record.get(i) + "~~" + secondRowList.get(i) + "##";
					}
					/*
					 * values = values.replace('\@@, ' '); values = values.replace('(', ' '); values
					 * = values.replace(')', ' '); values = values.replace(',', ' '); values =
					 * values.replace('/', ' ');
					 */
					// values=values.replace('-', ' ');
					// values=values.replace('#', ' ');
					if (i == record.size() - 1) {
						values = values + record.get(i) + "~~" + secondRowList.get(i);
					}
					sb = new StringBuilder(values);
					// sb.deleteCharAt(values.length() - 3);
					System.out.println(sb);

					try {
						CoreServiceCall csc = new CoreServiceCall();
						response = csc.insertDataInTable(tableName, sb.toString(), version);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		return response;

	}

	public static String convertCLOBToString(java.sql.Clob clobObject) {

		String clobAsString = null;

		try {
			InputStream in = clobObject.getAsciiStream();
			StringWriter w = new StringWriter();
			IOUtils.copy(in, w);
			clobAsString = w.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clobAsString;
	}

	public BaseOutput createAndWriteInAndWriteInAFile(String tableName, String tableQuery) {

		BaseOutput output = new BaseOutput();
		String dir = "C:\\My_Workbench\\MAVENWORKSPACE\\DATABASE\\FILES\\SCHEMA\\DEV\\TABLE_DATA_SCRIPTS\\";

		try {
			createAFile(tableName, dir);
			witeInAFile(tableName, tableQuery, dir);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		output.setErrorCode(0);
		output.setErrorDesc("Success");

		return output;

	}

	public static void createAFile(String tableName, String dir) {

		// String location = "C:\\Users\\junai\\OneDrive\\Documents\\";
		String fileName = dir + tableName + ".sql";
		System.out.println(fileName);

		try {
			File myObj = new File(fileName);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();

		}
	}

	public static void witeInAFile(String tableName, String tableScrpts, String dir) {

		// String location = "C:\\Users\\junai\\OneDrive\\Documents\\";
		String fileName = dir + tableName + ".sql";
		System.out.println(fileName);

		try {
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(tableScrpts);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public ArrayList<String> convertTableStringToQuery(String rawSQLData) {

		String newSt = rawSQLData;

		newSt = newSt.substring(0, newSt.length() - 3);
		System.out.println(newSt);
		String masterQuery = "";

		ArrayList<String> masterQueryList = new ArrayList<>();

		String masterData[] = newSt.split("~~~");

		for (int j = 0; j < masterData.length; j++) {

			String a = masterData[j];
			// System.out.println(a);

			// a = "JOB_HISTORY####EMPLOYEE_ID,START_DATE,END_DATE,JOB_ID,DEPARTMENT_ID ####
			// 200,01-JUL-02,31-DEC-06,AC_ACCOUNT,90####NUMBER,DATE,DATE,VARCHAR2,NUMBER";

			String ar[] = a.split("####");

			/*
			 * System.out.println(ar[0]); System.out.println(ar[1]);
			 * System.out.println(ar[2].trim()); System.out.println(ar[3]);
			 */
			try {
				String tableName = ar[0];
				String rows[] = ar[1].split(",");
				String tableData[] = ar[2].split(",");
				String tableDataType[] = ar[3].split(",");

				String rowName = "";
				String valueName = "";
				String v = ") values (";
				String ends = "');";
				String dateTypeFlag = "";

				String aa = "insert into " + tableName + " (";

				// System.out.println(aa);

				for (int i = 0; i < rows.length; i++) {

					rowName = rowName + "," + rows[i];
					if (!tableDataType[i].equals("DATE")) {

						valueName = valueName + "','" + tableData[i].trim();

					}
					if (tableDataType[i].trim().equals("DATE")) {
						// valueName=valueName+"','"+tableData[i].trim();
						dateTypeFlag = "T";
						valueName = valueName + "',to_date('" + tableData[i].trim() + "','dd-mm-yyyy')";

						// System.out.println("substringTest-------"+valueName.substring(valueName.length()-1,
						// valueName.length()));
					}
				}

				rowName = rowName.substring(1);
				valueName = valueName.substring(2);

				String fromReplace = "\\)',to_date\\('";
				String toReplace = "\\),to_date\\('";

				// System.out.println(v + valueName);
				String query = aa + rowName + v + valueName + ends;
				// System.out.println(query);
				masterQuery = query.replaceAll(fromReplace, toReplace);

				fromReplace = "-yyyy'\\)',";
				toReplace = "-yyyy'\\),";
				masterQuery = query.replaceAll(fromReplace, toReplace);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Some error");
			}

			masterQueryList.add(masterQuery);

		}
		return masterQueryList;
	}

	public BaseOutput fetchAndWriteTableDataQuery(String tableName) {
		BaseOutput response = new BaseOutput();
		Utility util = new Utility();

		String clobString = "";
		ArrayList<String> masterQueryList = new ArrayList<>();
		CoreServiceCall csc = new CoreServiceCall();

		try {
			clobString = csc.getClobTableData(tableName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String superMasterQuery = "";
		// Utility util = new Utility();
		try {
			masterQueryList = convertTableStringToQuery(clobString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utility util2 = new Utility();
		ImportURL url = new ImportURL();
		url.setFileLocation("C:\\Users\\junai\\Downloads\\BulkEmployees.csv");

		util2.setImportUrl(url);

		for (String masterQuery : masterQueryList) {
			try {

				System.out.println(masterQuery);

				superMasterQuery = superMasterQuery + "\r\n" + masterQuery;

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println(tableName);
		System.out.println(superMasterQuery);

		try {
			response = createAndWriteInAndWriteInAFile(tableName, superMasterQuery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public static String getLanguageAlphaCode(String language) {
		CoreServiceCall core = new CoreServiceCall();
		return core.getLanguageCode(language);
	}

	@Override
	public void run() {
		System.out.println("inside run method");
		Utility util = new Utility();
		String fileLocation = newImportUrl.getFileLocation();
		System.out.println(fileLocation);
		SimpleController simple = new SimpleController();
		try {
			simple.importUsers(newImportUrl);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String convertSingleStringToJsonType(String value) {
		value = "\"" + value + "\"";
		System.out.println(value);
		return value;
	}

	public static String insertApiLogs(String url, String request, String response) {
		CoreServiceCall core = new CoreServiceCall();

		return core.insertExternalApiLogs(url, request, response);
	}

	public static String insertInternalApiLogs(String url, String request, String response) {
		CoreServiceCall core = new CoreServiceCall();

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		// String json = ow.writeValueAsString(object);

		return core.insertInternalApiLogs(url, request, response);
	}

	public static List<Map> getClobDataToListOfMaps(String megaData, String primaryConcat, String secondaryConcat,
			String tertConcact) {

		// List<Map> superList = new ArrayList<>();
		List<Map> listOfMaps = new ArrayList<>();

		String megaDataArr[] = megaData.split(primaryConcat);
		for (int i = 0; i < megaDataArr.length; i++) {
			// System.out.println(megaDataArr[i]);

			String dataArr[] = megaDataArr[i].split(secondaryConcat);

			Map<String, String> retMap = new HashMap<>();
			for (int j = 0; j < dataArr.length; j++) {

				// System.out.println(tempData);

				String arr[] = dataArr[j].split(tertConcact);

				if (arr[0] != null && arr[1] != null)

					retMap.put(arr[1], arr[0]);
				// System.out.println(retMap);
			}
			listOfMaps.add(retMap);
			// System.out.println(listOfMaps);
			// superList.add(listOfMaps);
		}
		// System.out.println(superList);

		return listOfMaps;
	}

}
