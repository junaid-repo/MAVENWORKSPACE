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
import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.CustomerContact;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;
import com.jdbcdemo.jdbcdemo.dto.NewCustomerRequest;
import com.jdbcdemo.jdbcdemo.dto.PincodeDetails;
import com.jdbcdemo.jdbcdemo.dto.TrainDetailsResponse;
import com.jdbcdemo.reports.dto.Customer;
import com.jdbcdemo.reports.dto.ReceiptItem;
import com.jdbcdemo.service.CoreServiceCall;

import excelProject.ImportURL;
import externalApi.ExternalServices;
import multithread.MultiThreadOne;
import objectSetters.ObjectCreator;

public class Utility extends Thread implements Runnable {

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
		if (clobObject != null) {
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

					retMap.put(arr[0], arr[1]);
				// System.out.println(retMap);
			}
			listOfMaps.add(retMap);
			// System.out.println(listOfMaps);
			// superList.add(listOfMaps);
		}
		// System.out.println(superList);

		return listOfMaps;
	}

	public static NewCustomerRequest getADummyClassWithData() {

		NewCustomerRequest ncr = new NewCustomerRequest();
		CustomerContact con = new CustomerContact();

		ncr.setName("Dummy_Name");
		ncr.setType("O");
		ncr.setAddress("Dummy_Address");
		ncr.setWebsite("example.com");
		ncr.setCreditLimit(10000F);
		ncr.setCustomerContact(con);

		con.setFirstName("Dummy_FirstName");
		con.setLastName("Dummy_LastName");
		con.setEmail("example@example.com");
		con.setPhoneNumber("9999999999");

		return ncr;

	}

	public static Map<String, Object> createReportData() {
		Map<String, Object> data = new HashMap<>();
		Customer customer = new Customer();
		customer.setCompanyName("Simple Solution");
		customer.setContactName("John Doe");
		customer.setAddress("123, Simple Street");
		customer.setEmail("contact@simplesolution.dev");
		customer.setPhone("123 456 789");
		data.put("customer", customer);

		List<ReceiptItem> receiptItems = new ArrayList<>();
		ReceiptItem receiptItem1 = new ReceiptItem();
		receiptItem1.setDescription("Test Item 1");
		receiptItem1.setQuantity(1);
		receiptItem1.setUnitPrice(100.0);
		receiptItem1.setTotal(100.0);
		receiptItems.add(receiptItem1);

		ReceiptItem receiptItem2 = new ReceiptItem();
		receiptItem2.setDescription("Test Item 2");
		receiptItem2.setQuantity(4);
		receiptItem2.setUnitPrice(500.0);
		receiptItem2.setTotal(2000.0);
		receiptItems.add(receiptItem2);

		ReceiptItem receiptItem3 = new ReceiptItem();
		receiptItem3.setDescription("Test Item 3");
		receiptItem3.setQuantity(2);
		receiptItem3.setUnitPrice(200.0);
		receiptItem3.setTotal(400.0);
		receiptItems.add(receiptItem3);

		data.put("receiptItems", receiptItems);
		return data;
	}

	public static Map<String, Object> createOrderData(Map<String, Object> orderData) {
		Map<String, Object> data = new HashMap<>();

		Customer customer = new Customer();
		customer.setCompanyName("Junaid Solutions");
		customer.setContactName("Junaid Khan");
		customer.setAddress("123, Simple Street");
		customer.setEmail("contact@simplesolution.dev");
		customer.setPhone("123 456 789");
		data.put("customer", customer);

		List<Map> productDetails = (List<Map>) orderData.get("productDetails");
		List<ReceiptItem> receiptItems = new ArrayList<>();
		for (Map productMap : productDetails) {
			Integer quantity = Integer.parseInt((String) productMap.get("Quantity"));
			Double unitPrice = Double.parseDouble((String) productMap.get("Gross Price"));
			Double totalValue = Double.parseDouble((String) productMap.get("Net Price"));

			ReceiptItem receiptItem1 = new ReceiptItem();

			receiptItem1.setDescription((String) productMap.get("Product Name"));
			receiptItem1.setQuantity(quantity);
			receiptItem1.setUnitPrice(unitPrice);
			receiptItem1.setTotal(totalValue);
			receiptItems.add(receiptItem1);

		}
		data.put("receiptItems", receiptItems);
		return data;
	}

	public static void updatePincodeMasters(String pinCodeDetails, String trainNo) throws InterruptedException {

		String st1 = "";
		String st2 = "";
		String pin = "400001";
		String office = "Town Hall S.O (Mumbai)";
		String office_type = "S.O";
		String delivery = "Non-Delivery";
		String division = "Mumbai  South";
		String region = "Mumbai";
		String circle = "Maharashtra";
		String taluk = "Mumbai";
		String district = "Mumbai";
		String state_id = "19";
		String phone = "022-22660701";
		String related_suboffice = "Not Available";
		String related_headoffice = "Mumbai G.P.O. ";
		String longitude = "Not Available";
		String latitude = "Not Available";
		CoreServiceCall core = new CoreServiceCall();

		String paramName = "";
		String paramVal = "";
		String longString = "[{\"pin\":400001,\"office\":\"Bazargate S.O\",\"office_type\":\"S.O\",\"delivery\":\"Non-Delivery\",\"division\":\"Mumbai  South\",\"region\":\"Mumbai\",\"circle\":\"Maharashtra\",\"taluk\":\"Mumbai\",\"district\":\"Mumbai\",\"state_id\":19,\"phone\":\"022-22613927\",\"related_suboffice\":\"Not Available\",\"related_headoffice\":\"Mumbai G.P.O. \",\"longitude\":\"Not Available\",\"latitude\":\"Not Available\"},{\"pin\":400001,\"office\":\"Elephanta Caves Po B.O\",\"office_type\":\"B.O directly a/w Head Office\",\"delivery\":\"Delivery\",\"division\":\"Mumbai  South\",\"region\":\"Mumbai\",\"circle\":\"Maharashtra\",\"taluk\":\"Uran\",\"district\":\"Raigarh(MH)\",\"state_id\":19,\"phone\":\"Not Available\",\"related_suboffice\":\"Not Available\",\"related_headoffice\":\"Mumbai G.P.O. \",\"longitude\":\"Not Available\",\"latitude\":\"Not Available\"},{\"pin\":400001,\"office\":\"M.P.T. S.O\",\"office_type\":\"S.O\",\"delivery\":\"Non-Delivery\",\"division\":\"Mumbai  South\",\"region\":\"Mumbai\",\"circle\":\"Maharashtra\",\"taluk\":\"Mumbai\",\"district\":\"Mumbai\",\"state_id\":19,\"phone\":\"022-22617590\",\"related_suboffice\":\"Not Available\",\"related_headoffice\":\"Mumbai G.P.O. \",\"longitude\":\"Not Available\",\"latitude\":\"Not Available\"},{\"pin\":400001,\"office\":\"Stock Exchange S.O\",\"office_type\":\"S.O\",\"delivery\":\"Non-Delivery\",\"division\":\"Mumbai  South\",\"region\":\"Mumbai\",\"circle\":\"Maharashtra\",\"taluk\":\"Mumbai\",\"district\":\"Mumbai\",\"state_id\":19,\"phone\":\"022-22676041\",\"related_suboffice\":\"Not Available\",\"related_headoffice\":\"Mumbai G.P.O. \",\"longitude\":\"Not Available\",\"latitude\":\"Not Available\"},{\"pin\":400001,\"office\":\"Tajmahal S.O\",\"office_type\":\"S.O\",\"delivery\":\"Non-Delivery\",\"division\":\"Mumbai  South\",\"region\":\"Mumbai\",\"circle\":\"Maharashtra\",\"taluk\":\"Mumbai\",\"district\":\"Mumbai\",\"state_id\":19,\"phone\":\"022-22023549\",\"related_suboffice\":\"Not Available\",\"related_headoffice\":\"Mumbai G.P.O. \",\"longitude\":\"Not Available\",\"latitude\":\"Not Available\"},{\"pin\":400001,\"office\":\"Town Hall S.O (Mumbai)\",\"office_type\":\"S.O\",\"delivery\":\"Non-Delivery\",\"division\":\"Mumbai  South\",\"region\":\"Mumbai\",\"circle\":\"Maharashtra\",\"taluk\":\"Mumbai\",\"district\":\"Mumbai\",\"state_id\":19,\"phone\":\"022-22660701\",\"related_suboffice\":\"Not Available\",\"related_headoffice\":\"Mumbai G.P.O. \",\"longitude\":\"Not Available\",\"latitude\":\"Not Available\"},{\"pin\":400001,\"office\":\"Mumbai G.P.O. \",\"office_type\":\"H.O\",\"delivery\":\"Delivery\",\"division\":\"Mumbai G.P.O.\",\"region\":\"Mumbai\",\"circle\":\"Maharashtra\",\"taluk\":\"Mumbai\",\"district\":\"Mumbai\",\"state_id\":19,\"phone\":\"022-22620693\",\"related_suboffice\":\"Not Available\",\"related_headoffice\":\"Not Available\",\"longitude\":\"Not Available\",\"latitude\":\"Not Available\"}]";

		String[] st = pinCodeDetails.split("},");
		String trainDetails = ExternalServices.getTrainDetails(trainNo);
		for (int i = 0; i < st.length; i++) {
			st1 = st[i];

			StringBuffer stb = new StringBuffer(st1);
			st2 = st1.replace("[", "");
			st2 = st2.replace("{", "");
			st2 = st2.replace("}]", "");
			// System.out.println(st2);
			System.out.println("###################################################################");
			String[] innerSt = st2.split(",");
			for (int j = 0; j < innerSt.length; j++) {
				// System.out.println(innerSt[j]);

				String[] inst = innerSt[j].split(":");

				paramName = inst[0].replace('"', ' ');
				paramVal = inst[1].replace('"', ' ');

				if (paramName.trim().equals("pin"))
					pin = paramVal.trim();

				else if (paramName.trim().equals("office"))
					office = paramVal.trim();
				else if (paramName.trim().equals("office_type"))
					office_type = paramVal.trim();
				else if (paramName.trim().equals("delivery"))
					delivery = paramVal.trim();
				else if (paramName.trim().equals("division"))
					division = paramVal.trim();
				else if (paramName.trim().equals("region"))
					region = paramVal.trim();
				else if (paramName.trim().equals("circle"))
					circle = paramVal.trim();
				else if (paramName.trim().equals("taluk"))
					taluk = paramVal.trim();
				else if (paramName.trim().equals("district"))
					district = paramVal.trim();
				else if (paramName.trim().equals("state_id"))
					state_id = paramVal.trim();
				else if (paramName.trim().equals("phone"))
					phone = paramVal.trim();
				else if (paramName.trim().equals("related_suboffice"))
					related_suboffice = paramVal.trim();
				else if (paramName.trim().equals("related_headoffice"))
					related_headoffice = paramVal.trim();
				else if (paramName.trim().equals("longitude"))
					longitude = paramVal.trim();
				else if (paramName.trim().equals("latitude"))
					latitude = paramVal.trim();

			}

			System.out.println(pin + "," + pin + "," + office + "," + office_type + "," + delivery + "," + division
					+ "," + region + "," + circle + "," + taluk + "," + district + "," + state_id + "," + phone + ","
					+ related_suboffice + "," + longitude + "," + latitude);

			PincodeDetails pinCodeDt = new PincodeDetails();
			TrainDetailsResponse train = new TrainDetailsResponse();
			pinCodeDt = ObjectCreator.pinCodeDetailsSetter(pin, office, office_type, delivery, division, region, circle,
					taluk, district, state_id, phone, related_suboffice, related_headoffice, longitude, latitude,
					trainNo);

			MultiThreadOne multi = new MultiThreadOne();

			train = ObjectCreator.trainDetailsSetter(trainNo, trainDetails);

			multi.updatePincode(pinCodeDt, train);

		}

	}

}
