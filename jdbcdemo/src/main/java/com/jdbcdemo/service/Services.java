package com.jdbcdemo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.BulkEmployeesResponse;
import com.jdbcdemo.jdbcdemo.dto.CountryGDPList;
import com.jdbcdemo.jdbcdemo.dto.CountryGDPResponse;
import com.jdbcdemo.jdbcdemo.dto.DepartmentDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.EmailRequest;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeResponse;
import com.jdbcdemo.jdbcdemo.dto.JobDetails;
import com.jdbcdemo.jdbcdemo.dto.NewCustomerRequest;
import com.jdbcdemo.jdbcdemo.dto.OrderPaymentRequest;
import com.jdbcdemo.jdbcdemo.dto.OrderPaymentResponse;
import com.jdbcdemo.jdbcdemo.dto.TranslateText;
import com.jdbcdemo.jdbcdemo.interfaces.CreateEmployeeInBulkIF;
import com.jdbcdemo.jdbcdemo.interfaces.ICompany;
import com.jdbcdemo.jdbcdemo.interfaces.IDoCollection;
import com.jdbcdemo.jdbcdemo.interfaces.IDownloadFile;
import com.jdbcdemo.jdbcdemo.interfaces.IExportTableDataAsScript;
import com.jdbcdemo.jdbcdemo.interfaces.IFN01;
import com.jdbcdemo.jdbcdemo.interfaces.IFN02;
import com.jdbcdemo.jdbcdemo.interfaces.IFN03;
import com.jdbcdemo.jdbcdemo.interfaces.IGDPCountries;
import com.jdbcdemo.jdbcdemo.interfaces.ISendSimpleEmail;
import com.jdbcdemo.jdbcdemo.interfaces.IServices;
import com.jdbcdemo.jdbcdemo.interfaces.ITextTranslate;
import com.jdbcdemo.jdbcdemo.interfaces.IUploadFile;
import com.jdbcdemo.service.CoreServiceCall;

import externalApi.ExternalServices;
import utility.Utility;

@Component
public class Services extends Thread implements IServices, IFN02, IFN03, IExportTableDataAsScript, IGDPCountries,
		IUploadFile, IDownloadFile, ITextTranslate, ISendSimpleEmail, Runnable, ICompany, IDoCollection {
	@Value("${upload-dir}")
	private static String FILE_DIRECTORY = "C:/Users/junai/OneDrive/Documents/FileUploadDir/";
	@Autowired
	CoreServiceCall bs;

	public EmployeeDetailsResponse getEmployeeLists(String empId) {

		EmployeeDetailsResponse response = new EmployeeDetailsResponse();
		CoreServiceCall bs = new CoreServiceCall();
		response = bs.getEmployeeLists(empId);

		return response;
	}

	@Override
	public InsertEmployeeResponse insertNewEmployee(InsertEmployeeList request) {
		// InsertEmployeeList employeeList = new ArrayList<>();
		InsertEmployeeResponse response = new InsertEmployeeResponse();
		// CoreServiceCall bs = new CoreServiceCall();
		String empId = "";
		response = bs.insertNewEmployee(request);

		return response;

	}

	@Override
	public EmployeeDetailsResponse getEmployeeDetails(String empId) {
		// TODO Auto-generated method stub
		EmployeeDetailsResponse response = new EmployeeDetailsResponse();

		response = bs.getEmployeeDetails(empId);

		float sal = response.getSalary();
		CopyOnWriteArrayList<Float> salaryList = new CopyOnWriteArrayList<>();
		salaryList.add(sal);

		System.out.println("printting to check lambda");

		if (checkEvenSalary(salaryList))

		// salaryList.stream().filter(i -> i % 2 == 1).forEach(System.out::println);
		// System.out.println();
		{
			return response;
		}

		else {
			response.setErrorDesc("Odd Salary");
			return response;
		}
	}

	private static boolean checkEvenSalary(List<Float> salary) {
		return salary.stream().allMatch(i -> i % 2 == 0);

	}

	@Override
	public BaseOutput removeEmployee(String empId) {
		BaseOutput response = new BaseOutput();
		response = bs.removeEmployee(empId);
		return response;
	}

	public BaseOutput freezeEmployee(String empId) {

		IFN01 fo = (String emId) -> {
			CoreServiceCall bss = new CoreServiceCall();
			BaseOutput response = new BaseOutput();
			response = bss.freezeEmployee(empId);

			return response;

		};

		return fo.freezeEmployee(empId);

	}

	public BulkEmployeesResponse createBulkEmployee(List<InsertEmployeeList> employeeList) {
		BulkEmployeesResponse response = new BulkEmployeesResponse();

		List<String> emailList = new ArrayList<>();

		for (InsertEmployeeList eList : employeeList) {
			emailList.add(eList.getEmail());
		}
		if (validateEmailId(emailList)) {

			CreateEmployeeInBulkIF cf = (List<InsertEmployeeList> empList) -> {

				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						CoreServiceCall bst = new CoreServiceCall();
						InsertEmployeeResponse empResponse = new InsertEmployeeResponse();
						List<InsertEmployeeResponse> empList5 = new ArrayList<>();
						for (InsertEmployeeList empList3 : empList.stream().toList()) {

							empResponse = bst.insertNewEmployee(empList3);

							empList5.add(empResponse);
							response.setNewEmployeesResponse(empList5);

						}

					}

				});
				thread.start();
				try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return response;

			};

			return cf.createBulkEmployees(employeeList);

		}
		response.setErrorCode(1001);
		response.setErrorDesc("email is not from well knowns TLDs");
		return response;
	}

	private boolean validateEmailId(List<String> emailList) {
		// TODO Auto-generated method stub
		return emailList.stream()
				.allMatch(mail -> mail.contains("@gmail.") || mail.contains("@yahoo.") || mail.contains("@outlook."));
	}

	public Double sumOfDeptWiseSalary(String deptId) {

		CoreServiceCall bst = new CoreServiceCall();
		List<Double> sumOfSalary = new ArrayList<>();

		sumOfSalary = bst.sumOfSalary(deptId, "department_id");

		BinaryOperator<Double> accumulator = new BinaryOperator<Double>() {

			@Override
			public Double apply(Double t, Double u) {
				// TODO Auto-generated method stub
				return t + u;
			}

		};
		Double sum;

		sum = extracted2(sumOfSalary);
		return sum;
	}

	private Double extracted(List<Double> sumOfSalary) {
		return sumOfSalary.stream().reduce(0D, (x, y) -> x + y);
	}

	private Double extracted2(List<Double> sumOfSalary) {
		return sumOfSalary.stream().reduce(0D, (x, y) -> x - y);
	}

	public Double wiseCalcuation(String wise, String type, String id) {

		CoreServiceCall bst = new CoreServiceCall();
		List<Double> salaryList = new ArrayList<>();

		salaryList = bst.sumOfSalary(id, wise);

		Double response = 0D;

		if (type.equals("sum"))
			response = extracted(salaryList);
		if (type.equals("average")) {
			Long size = salaryList.stream().count();

			response = (double) Math.round(salaryList.stream().reduce(0D, (x, y) -> (x + y)) / size);

		}
		return response;

	}

	public List<JobDetails> jobDetails(String minSalary) {

		List<JobDetails> jobList = new ArrayList<>();
		CoreServiceCall bst = new CoreServiceCall();
		jobList = bst.jobDetails(minSalary);
		List<JobDetails> jobList2 = new ArrayList<>();

		jobList.sort(Comparator.comparing(JobDetails::getJobId).reversed());
		List<String> jobList4 = new ArrayList<>();
		// ----------------------------------------------------------------------------------------
		Function<JobDetails, String> mapper = JobDetails::getJobId;
		Function<JobDetails, String> mapper2 = new Function<JobDetails, String>() {

			@Override
			public String apply(JobDetails t) {
				// TODO Auto-generated method stub
				return t.getJobId();
			}

		};
		Predicate<String> predicate = i -> i.contains("ager");
		Predicate<String> predicate2 = new Predicate<String>() {

			@Override
			public boolean test(String t) {

				return t.contains("ager") == false;
			}

		};

		Collector<String, ?, List<String>> listColl = Collectors.toList();

		jobList4 = jobList.stream().map(JobDetails::getJobId).filter(i -> i.contains("ager")).collect(listColl);
		Consumer<String> action = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t + "--");

			}

		};
		jobList.stream().map(mapper2).filter(predicate2).forEach(action);
		System.out.println(jobList4);

		Supplier<Integer> supp = () -> {

			Random rand = new Random();
			return rand.nextInt(10000, 999999);
		};

		System.out.println("The generated random number is---->" + supp.get());
		// ----------------------------------------------------------------------------------------

		return jobList;

	}

	public List<Integer> empIdList(String salary) {
		List<Integer> empIdList = new ArrayList<>();
		CoreServiceCall bst = new CoreServiceCall();
		List<Integer> response = new ArrayList<>();
		empIdList = bst.getEmpIdAccToSalary(salary);
		response = empIdList.stream().sorted().collect(Collectors.toList());

		return response;
	}

	@Override
	public List<Integer> empIdListNew(String salary) {
		List<Integer> response = new ArrayList<>();
		List<Integer> response3 = new ArrayList<>();
		CoreServiceCall bst = new CoreServiceCall();
		IFN02 fn02 = (String sal) -> {
			List<Integer> response2 = new ArrayList<>();
			response2 = bst.getEmpIdAccToSalary(salary);
			return response2;
		};
		response = fn02.empIdListNew(salary);
		response3 = response;

		Predicate<Integer> predicateType = i -> i % 2 == 1;
		extractedType(response3, predicateType);

		return response;
	}

	private void extractedType(List<Integer> response3, Predicate<Integer> predicateType) {
		response3.stream().filter(predicateType).forEach(System.out::println);
	}

	@Override
	public DepartmentDetailsResponse getDeptDetails(String deptId) {
		DepartmentDetailsResponse response = new DepartmentDetailsResponse();
		CoreServiceCall bst = new CoreServiceCall();

		IFN03 obj = (String deptId2) -> {

			System.out.println("Inside lambda Calling of functional interface");
			return bst.getDeptDetails(deptId);

		};
		response = obj.getDeptDetails(deptId);

		Function<DepartmentDetailsResponse, String> getAddress = new Function<DepartmentDetailsResponse, String>() {

			@Override
			public String apply(DepartmentDetailsResponse t) {
				Predicate<String> checkVowels = new Predicate<String>() {

					@Override
					public boolean test(String t) {
						// TODO Auto-generated method stub
						return t.contains("Centre");
					}

				};

				String add = "";
				if (checkVowels.test(t.getAddress())) {
					add = "OK";
				}

				return add;
			}

		};

		Consumer<String> printIt = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);

			}

		};

		response.setErrorDesc(getAddress.apply(response));

		return response;
	}

	public BaseOutput tableAndDataCreate(String location, String version) throws FileNotFoundException, IOException {

		BaseOutput response = new BaseOutput();
		String errorDesc = "Success";
		BaseOutput base = new BaseOutput();
		Utility util = new Utility();
		// String st = "C:\\Users/junai/Downloads\\BulkEmployees.csv";

		location = location.replace('\\', '/');
		System.out.println(location);

		String ar[] = location.split("/");
		String tableN = ar[ar.length - 1];

		tableN = tableN.substring(0, tableN.length() - 4);

		System.out.println(tableN);

		char tableCheckFlag = 'T';
		String tableType = "R";

		if (version.equals("simple"))
			tableType = "NR";
		else if (version.equals("relational"))
			tableType = "R";
		else {
			response.setErrorCode(100);
			response.setErrorDesc("Type selected in the URI is wrong");
			return response;
		}
		tableCheckFlag = CoreServiceCall.checkTableExistence(tableN);
		if (tableCheckFlag == 'F') {
			response = util.createTableWithColumnType(tableN, location, tableType);
		}

		if (response.getErrorCode() == 0) {
			response = util.insertDataInTable_WithColoumnName(tableN, location, tableType);
		}

		return response;

	}

	@Override
	public BaseOutput exportTableDataAsScript(String tableName) {
		// TODO Auto-generated method stub

		BaseOutput response = new BaseOutput();

		IExportTableDataAsScript export = (String tbName) -> {

			List<String> tableList = new ArrayList<>();
			String tableExistenceFlag = "F";

			BaseOutput bo = new BaseOutput();
			Utility util = new Utility();
			if (tableName.toUpperCase().equals("ALL")) {
				try {
					CoreServiceCall csc = new CoreServiceCall();
					tableList = csc.getNamesOfDBTables("DEV");
					for (String tempTableName : tableList) {
						if (!tempTableName.equals("TABLERAWSTRUCTURE"))
							bo = util.fetchAndWriteTableDataQuery(tempTableName);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				CoreServiceCall csc = new CoreServiceCall();
				tableList = csc.getNamesOfDBTables("DEV");
				for (String tempTableName : tableList) {
					if (tempTableName.toUpperCase().equals(tableName.toUpperCase())) {
						tableExistenceFlag = "T";
						break;
					}
				}
				if (tableExistenceFlag.equals("T"))
					bo = util.fetchAndWriteTableDataQuery(tbName);
				else {
					bo.setErrorCode(100);
					bo.setErrorDesc("Table Doesn't exist for user DEV");
				}
			}

			return bo;

		};
		response = export.exportTableDataAsScript(tableName);
		return response;

	}

	public CountryGDPResponse getGDPWiseCounrties(String year, String gpd) {

		IGDPCountries obj = (String year2, String gdp2) -> {
			CountryGDPResponse response = new CountryGDPResponse();
			CountryGDPResponse response2 = new CountryGDPResponse();
			List<CountryGDPList> countryGDPList2 = new ArrayList<>();

			CoreServiceCall core = new CoreServiceCall();
			response2 = core.getYearWiseGDPofWorld(year);

			List<CountryGDPList> countryGDPList = new ArrayList<>();

			countryGDPList = response2.getCountryGDPList();

			// getGPDFilter(gpd, response, response2, countryGDPList2, countryGDPList);

			countryGDPList.sort(Comparator.comparing(CountryGDPList::getGpd).reversed());

			countryGDPList.stream().map(CountryGDPList::getGpd).filter(i -> i >= 7000);

			response2.getCountryGDPList().forEach(obj3 -> {

				if (obj3.getGpd() >= Long.valueOf(gpd)) {
					countryGDPList2.add(obj3);
				}
			});
			response2.setCountryGDPList(countryGDPList2);
			System.out.println(countryGDPList.stream().map(CountryGDPList::getGpd).filter(i -> i >= 7000)
					.collect(Collectors.toList()));

			return response2;
		};

		return obj.getGDPWiseCounrties(year, gpd);

	}

	private void getGPDFilter(String gpd, CountryGDPResponse response, CountryGDPResponse response2,
			List<CountryGDPList> countryGDPList2, List<CountryGDPList> countryGDPList) {
		for (CountryGDPList dpList : countryGDPList) {

			if (dpList.getGpd() >= Long.valueOf(gpd)) {
				countryGDPList2.add(dpList);
			}

			response.setCountryGDPList(countryGDPList2);
			response.setErrorCode(response2.getErrorCode());
			response.setErrorDesc(response2.getErrorDesc());
		}
	}

	@Override
	public String uploadFile(MultipartFile file) {

		String docId = "";
		IUploadFile upload = (MultipartFile file2) -> {
			File myFile = new File(FILE_DIRECTORY + file2.getOriginalFilename());
			try {

				System.out.println(myFile.toString());
				myFile.createNewFile();
				FileOutputStream fos = new FileOutputStream(myFile);
				fos.write(file2.getBytes());
				fos.close();

				CoreServiceCall core = new CoreServiceCall();
				return core.insertDocDetails(file2.getOriginalFilename(), myFile.toString());

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return myFile.toString();
		};

		String response = upload.uploadFile(file);

		return response;
	}

	@Override
	public String DownloadFile(String docId) {
		IDownloadFile down = (String documentId) -> {
			CoreServiceCall core = new CoreServiceCall();
			String filePath = core.getStoredFileLocation(documentId);
			return filePath;
		};

		return down.DownloadFile(docId);
	}

	public BaseOutput exportTableDataAsScriptWithThreads(String tableName) {
		// TODO Auto-generated method stub

		BaseOutput response = new BaseOutput();

		IExportTableDataAsScript export = (String tbName) -> {

			List<String> tableList = new ArrayList<>();
			String tableExistenceFlag = "F";

			BaseOutput bo = new BaseOutput();
			Utility util = new Utility();
			if (tableName.toUpperCase().equals("ALL")) {
				try {
					CoreServiceCall csc = new CoreServiceCall();
					tableList = csc.getNamesOfDBTables("DEV");
					for (String tempTableName : tableList) {
						if (!tempTableName.equals("TABLERAWSTRUCTURE"))
							bo = util.fetchAndWriteTableDataQuery(tempTableName);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {

				CoreServiceCall csc = new CoreServiceCall();
				tableList = csc.getNamesOfDBTables("DEV");
				for (String tempTableName : tableList) {
					if (tempTableName.toUpperCase().equals(tableName.toUpperCase())) {
						tableExistenceFlag = "T";
						break;
					}
				}
				if (tableExistenceFlag.equals("T"))
					bo = util.fetchAndWriteTableDataQuery(tbName);
				else {
					bo.setErrorCode(100);
					bo.setErrorDesc("Table Doesn't exist for user DEV");
				}
			}

			return bo;

		};
		response = export.exportTableDataAsScript(tableName);
		return response;

	}

	@Override
	public String textTranslate(TranslateText textDetails) {

		ITextTranslate trans = String -> {

			ExternalServices serv = new ExternalServices();
			String translatedText = "";

			String textToTranslate = textDetails.getText();
			String fromLang = Utility.getLanguageAlphaCode(textDetails.getFrom());
			String toLang = Utility.getLanguageAlphaCode(textDetails.getTo());

			System.out.println(fromLang);
			System.out.println(toLang);

			translatedText = serv.translateText(textToTranslate, fromLang, toLang);

			return translatedText;

		};
		return trans.textTranslate(textDetails);

	}

	@Override
	public BaseOutput sendSimpleMail(EmailRequest emailRequest) {
		// TODO Auto-generated method stub
		ISendSimpleEmail obj = BaseOutput -> {
			BaseOutput response = new BaseOutput();
			String from = emailRequest.getFrom();
			String to = emailRequest.getTo();
			String subject = emailRequest.getSubject();
			String messageBody = emailRequest.getMailBody();

			ExternalServices ext = new ExternalServices();
			int errorCode = 0;
			String errorDesc = "Success";

			errorDesc = ext.sendSimpleMail(messageBody, subject, from, to);

			response.setErrorCode(errorCode);
			response.setErrorDesc(errorDesc);

			return response;

		};
		return obj.sendSimpleMail(emailRequest);
	}

	public Map getCountriesDetails(String paramName, String paramValue, String comp) {
		Map<String, Object> response = new HashMap();
		CoreServiceCall csc = new CoreServiceCall();
		Map<String, String> retMap = new HashMap<>();
		List<Map> megaList = new ArrayList<>();
		retMap = csc.getCountryDetails(paramName, paramValue, comp);
		if (retMap.get("clobData") != null) {
			try {
				megaList = Utility.getClobDataToListOfMaps(retMap.get("clobData"), retMap.get("primaryConcat"),
						retMap.get("secondaryConcat"), retMap.get("tertConcat"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.put("response", megaList);

		return response;

	}

	public synchronized Map createBulkEmployeeAndGetCountryData(List<InsertEmployeeList> employeeList, String paramName,
			String paramValue, String comp, int threadTime) throws InterruptedException {

		long startTime = System.currentTimeMillis() / 1000;
		BulkEmployeesResponse response = new BulkEmployeesResponse();
		Map<String, Object> retResponse = new HashMap<>();
		List<InsertEmployeeResponse> newEmployeesResponse = new ArrayList<>();
		// CreateEmployeeInBulkIF cf = (List<InsertEmployeeList> empList) -> {

		CoreServiceCall bst = new CoreServiceCall();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				List<InsertEmployeeResponse> empList5 = new ArrayList<>();

				for (InsertEmployeeList empList3 : employeeList.stream().toList()) {
					InsertEmployeeResponse empResponse = new InsertEmployeeResponse();
					try {
						Thread.sleep(threadTime);
						empResponse = bst.insertNewEmployee(empList3);

						empList5.add(empResponse);
						response.setNewEmployeesResponse(empList5);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				System.out.println(empList5);

				System.out.println("This much time it took in the run method of create Employees");
				System.out.println((System.currentTimeMillis() / 1000) - startTime);
			}
		});
		t1.setPriority(MIN_PRIORITY);
		t1.start();
		t1.join();

		// return response;
		// };

		// return cf.createBulkEmployees(employeeList);
		Services serv = new Services();

		List<Map> responseList = new ArrayList<>();

		for (InsertEmployeeResponse ier : response.getNewEmployeesResponse()) {
			String location = ServletUriComponentsBuilder
					.fromHttpUrl(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString()
							+ "/webService/getEmployeeDetails")
					.path("/{id}").buildAndExpand(ier.getEmpId()).toUri().toString();

			System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
			InsertEmployeeResponse obj = new InsertEmployeeResponse();

			Map<String, Object> retMap = new HashMap<>();
			retMap.put("errorCode", HttpStatus.CREATED.getReasonPhrase());
			retMap.put("errorDesc", HttpStatus.CREATED.value());
			retMap.put("empId", ier.getEmpId());
			retMap.put("url", location);
			responseList.add(retMap);

			obj.setErrorDesc(HttpStatus.CREATED.getReasonPhrase());
			obj.setErrorCode(HttpStatus.CREATED.value());
			obj.setEmpId(ier.getEmpId());
			obj.setUrl(location);
			newEmployeesResponse.add(obj);
		}

		retResponse.put("employeeList", newEmployeesResponse);

		// ----------------------------------------------------------------------------

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {

				Map<String, Object> responseCountry = new HashMap();
				CoreServiceCall csc = new CoreServiceCall();
				Map<String, String> retMap = new HashMap<>();
				List<Map> megaList = new ArrayList<>();
				retMap = csc.getCountryDetails(paramName, paramValue, comp);
				if (retMap.get("clobData") != null) {
					try {
						megaList = Utility.getClobDataToListOfMaps(retMap.get("clobData"), retMap.get("primaryConcat"),
								retMap.get("secondaryConcat"), retMap.get("tertConcat"));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("This much time it took in the run method of Countires Details");
				System.out.println((System.currentTimeMillis() / 1000) - startTime);
				System.out.println(megaList);
				retResponse.put("response", megaList);

			}
		});
		t2.setPriority(MAX_PRIORITY);
		t2.start();
		t2.join();

		System.out.println("This much time it took in the Service class for this Service");
		System.out.println((System.currentTimeMillis() / 1000) - startTime);
		return retResponse;
	}

	@Override
	public Map saveNewCustomer(NewCustomerRequest newCustomer) {

		Map<String, Object> response = new HashMap<>();

		String name = newCustomer.getName();
		String address = newCustomer.getAddress();
		String website = newCustomer.getWebsite();
		Float creditLimit = newCustomer.getCreditLimit();
		String type = newCustomer.getType();

		String getFirstName = newCustomer.getCustomerContact().getFirstName();
		String lastName = newCustomer.getCustomerContact().getLastName();
		String email = newCustomer.getCustomerContact().getEmail();
		String phoneNumer = newCustomer.getCustomerContact().getPhoneNumber();

		CoreServiceCall core = new CoreServiceCall();
		response = core.createNewCustomer(name, address, website, creditLimit, type, getFirstName, lastName, email,
				phoneNumer);

		return response;
	}

	@Override
	public Map calculateOrderValue(String orderNumber) {
		CoreServiceCall core = new CoreServiceCall();
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> retMap = new HashMap<>();
		retMap = core.calculateOrderValue(orderNumber);
		List<Map> megaList = new ArrayList<>();

		if (retMap.get("clobData") != null) {
			try {
				megaList = Utility.getClobDataToListOfMaps((String) retMap.get("clobData"), "##", "~~", "@@");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.put("orderNumber", orderNumber);
		response.put("productDetails", megaList);
		response.put("grossAmount", retMap.get("grossAmount"));
		response.put("gstAmount", retMap.get("gstAmount"));
		response.put("netAmount", retMap.get("netAmount"));
		return response;

	}

	@Override
	public Map createNewOrder(Map orderDetails) {
		String customerCode = (String) orderDetails.get("customerCode");
		String employeeCode = (String) orderDetails.get("employeeCode");
		String orderCode = "";
		List<Map> itemList = new ArrayList<>();
		Map<String, Object> itemMapOut = new HashMap<>();
		Map<String, Object> retMap = new HashMap<>();
		Map<String, Object> response = new HashMap<>();
		itemList = (List<Map>) orderDetails.get("itemLists");
		CoreServiceCall core = new CoreServiceCall();
		int itemCount = 0;
		if (customerCode.equals("") || customerCode == null) {
			NewCustomerRequest newCustomer = new NewCustomerRequest();
			newCustomer = Utility.getADummyClassWithData();

			Map<String, Object> newCustomerMap = new HashMap<>();
			newCustomerMap = saveNewCustomer(newCustomer);
			customerCode = (String) newCustomerMap.get("customerCode");

		}

		if (customerCode != null) {
			retMap = core.createSingleOrder(customerCode, employeeCode);
		}
		orderCode = (String) retMap.get("orderCode");
		if (!orderCode.equals("")) {

			for (Map itemMap : itemList) {
				itemCount++;

				itemMapOut = core.insertOrderItems(itemMap, orderCode, itemCount);

			}

		}

		if (!orderCode.equals("")) {
			response = calculateOrderValue(orderCode);
			core.updateOrderData((String) response.get("orderNumber"), (Float) response.get("grossAmount"),
					(Float) response.get("gstAmount"), (Float) response.get("netAmount"));

		}

		response.put("CustomerCode", customerCode);
		return response;

	}

	@Override
	public Map getEmployeeData(String employeeCode) {
		CoreServiceCall core = new CoreServiceCall();
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> retMap = new HashMap<>();
		retMap = core.getEmployeeData(employeeCode);
		List<Map> megaList = new ArrayList<>();

		if (retMap.get("clobData") != null) {
			try {
				megaList = Utility.getClobDataToListOfMaps((String) retMap.get("clobData"), "##", "~~", "@@");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.put("employeeCode", employeeCode);
		response.put("ordersList", megaList);
		response.put("grossAmount", retMap.get("grossAmount"));
		response.put("gstAmount", retMap.get("gstAmount"));
		response.put("netAmount", retMap.get("netAmount"));
		return response;

	}

	@Override
	public OrderPaymentResponse doCollection(OrderPaymentRequest request) {
		// TODO Auto-generated method stub
		OrderPaymentResponse response = new OrderPaymentResponse();
		IDoCollection coll = (OrderPaymentRequest request1) -> {
			String paymentMethod = request1.getPaymentMethod();

			if (paymentMethod.equals("ONLINE")) {
				Thread thread = new Thread(new Runnable() {
					@Override
					public void run() {

					}
				});
				thread.start();
			}
			

			OrderPaymentResponse order = new OrderPaymentResponse();
			return order;

		};
		response = coll.doCollection(request);

		return response;
	}
	public Map updateAndGetChat(String sender, String receiver, String text) {
		Map<String, Object> response = new HashMap();
		CoreServiceCall csc = new CoreServiceCall();
		Map<String, String> retMap = new HashMap<>();
		List<Map> megaList = new ArrayList<>();
		retMap = csc.updateAndGetChatData(sender, receiver, text);
		if (retMap.get("clobData") != null) {
			try {
				megaList = Utility.getClobDataToListOfMaps(retMap.get("clobData"), retMap.get("primaryConcat"),
						retMap.get("secondaryConcat"), retMap.get("tertConcat"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.put("response", megaList);

		return response;

	}
}
