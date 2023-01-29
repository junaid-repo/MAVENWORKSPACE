package com.jdbcdemo;

public class URIConstants {

	public static final String GET_EMPLOYEE_DETAILS = "webService/getEmployeeLists";
	public static final String ADD_EMPLOYEE = "webService/addEmployee";
	public static final String GET_EMPLOYEE_DETAIL = "webService/getEmployeeDetails/{empId}";
	public static final String REMOVE_EMPLOYEE = "webService/deleteUser/{empId}";
	public static final String FREEZE_EMPLOYEE = "webService/freezeEmployee/{empId}";
	public static final String CREATE_BULK_EMPLOYEE = "webService/createBulkEmployee";
	public static final String IMPORT_BULK_EMPLOYEE = "webService/importBulkUsers";
	public static final String DELETE_BULK_EMPLOYEE = "webService/deleteBulkUser";
	public static final String DEPT_WISE_TOTAL_SALARY = "webService/deptWiseTotalSalary/{type}/{deptId}";
	public static final String WISE_CALCULATION = "webService/wiseCalculation/{wise}/{type}/{id}";
	public static final String JOB_DETAILS = "webService/jobDetailsWithMinimumSalaryOfAndSortedByMaxSalaryDesc/{minimumSalary}";
	public static final String LIST_EMPLOYEES = "webService/getEmpIdAccordingToMiniumSalaryOf/{minSalary}";
	public static final String GET_DEPARTMENT_DETAILS = "webService/getDetpartmentDetails/{deptId}";
	public static final String CREATE_UPLOAD_TABLE_FROM_URI = "webService/createAndUploadTablesAndData/{tableName}";
	public static final String EXPORT_TABLE_DATA_AS_SCRIPT = "webService/exportTableDataAs_SQL_Script/{tableName}";
	public static final String GET_GDP_WISE_COUNRTY = "webService/getGPDWiseCountries";
	public static final String UPLOAD_TABLE_WITH_DATA = "webService/{version}/uploadDataTable";
	public static final String FILE_UPLOAD = "/fileUpload";
	public static final String EXPORT_TABLE_DATA = "tableDataAs_SQL_Script/{tableName}";
	public static final String FILE_DOWNLOAD = "/fileDownload/{docId}";
	public static final String TRANSLATE_TEXT = "/external/translateText";
	public static final String SEND_SIMPLE_EMAIL = "/external/sendSimpleEmail";
	public static final String GET_COUNTRY_DETAILS = "/webService/getCountryDetails";
	public static final String CREATE_BULK_EMPLOYEE_AND_GET_COUNTRY_DATA = "webService/createBulkEmployeeAndGetCountryData";
	public static final String CREATE_NEW_CUSTOMER = "company/createNewCustomer";
	public static final String CALCULATE_ORDER_VALUE = "company/calculateOrderValue";
	public static final String CREATE_NEW_ORDER = "company/createNewOrder";
	public static final String DOWNLOAD_REPORT = "company/downloadReport";
	public static final String DOWNLOAD_ORDER_PDF = "company/downloadOrderPDF";
	public static final String GET_EMPLOYEE_DATA = "company/getEmployeeData";
	public static final String GET_EMPLOYEE_REPORT = "company/getEmployeeReport";
	public static final String COLLECTION = "company/collection";
	public static final String GET_LOCATION_DETAILS = "/external/getCityDetails";
	public static final String CREATE_USER = "/createUser";
	public static final String CHAT = "/chat/startChat";

}
