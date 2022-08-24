package com.jdbcdemo.jdbcdemo.coreCall;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.CountryGDPList;
import com.jdbcdemo.jdbcdemo.dto.CountryGDPResponse;
import com.jdbcdemo.jdbcdemo.dto.DepartmentDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetails;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeResponse;
import com.jdbcdemo.jdbcdemo.dto.JobDetails;
import com.jdbcdemo.jdbcdemo.dto.Property;
import com.jdbcdemo.jdbcdemo.dto.Report;
import com.jdbcdemo.jdbcdemo.properties.AppProperties;

import connection.ConnectionClass;
import oracle.jdbc.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import recordTab.TRECORDTAB;
import utility.Utility;

@Service
@Component
public class CoreServiceCall {

	public EmployeeDetailsResponse getEmployeeLists(String empId) {

		EmployeeDetailsResponse response = new EmployeeDetailsResponse();
		BaseOutput baseOutput = new BaseOutput();

		ArrayList<EmployeeDetails> employeeDetails = new ArrayList<>();
		String errorDesc = "";
		int errorCode = 0;

		String details = "";
		baseOutput.setErrorCode(0);
		baseOutput.setErrorDesc("Success");

		// Load Oracle JDBC Driver
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			// Connect to Oracle Database
			Connection conn = null;
			try {
				conn = ConnectionClass.getEDBConnection();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Statement cstmt = conn.createStatement();
			CallableStatement st = null;
			if (conn != null) {
				try {
					st = conn.prepareCall("{call dev.getEmployeesByDeptId(?,?,?,?)}");
					st.setString(1, empId);
					st.registerOutParameter(2, java.sql.Types.VARCHAR);
					st.registerOutParameter(3, java.sql.Types.DOUBLE);
					st.registerOutParameter(4, java.sql.Types.VARCHAR);
					st.execute();
					details = st.getString(2);
					errorCode = (int) st.getLong(3);
					errorDesc = st.getString(4);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					st.close();
					e.printStackTrace();
				}
			}

			System.err.println(details);

			// Execute a SELECT query on Oracle Dummy DUAL Table. Useful for retrieving
			// system values
			// Enables us to retrieve values as if querying from a table
			ResultSet rs = cstmt.executeQuery("SELECT SYSDATE FROM DUAL");

			if (rs.next()) {
				Date currentDate = rs.getDate(1); // get first column returned
				System.out.println("Current Date from Oracle is : " + currentDate);
			}
			rs.close();
			cstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeDetails em = new EmployeeDetails();

		/*
		 * Utility ob =new Utility(); employeeDetails = ob.changeData(details, "##",
		 * em);
		 */
		String D1[] = details.split("##");
		for (int i = 0; i < D1.length; i++) {

			EmployeeDetails emp = new EmployeeDetails();

			String D2[] = D1[i].split("~~");

			System.out.println(D2[0]);

			emp.setEmpId(D2[0]);
			emp.setName(D2[1]);
			emp.setSalary(Long.valueOf(D2[2]));
			employeeDetails.add(emp);

		}

		System.out.println(employeeDetails);

		response.setEmployeeDetails(employeeDetails);
		response.setErrorCode(0);
		response.setErrorDesc("Success");

		return response;
	}

	public InsertEmployeeResponse insertNewEmployee(InsertEmployeeList employeeList) {
		// TODO Auto-generated method stub
		InsertEmployeeResponse response = new InsertEmployeeResponse();
		String empId = "0";
		String errorDesc = "Success";
		int errorCode = 0;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection conn = null;
			try {
				conn = ConnectionClass.getEDBConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Statement cstmt = conn.createStatement();
			CallableStatement st = null;

			if (conn != null) {

				try {
					st = conn.prepareCall("{call dev.createNewEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}");
					// st = conn.prepareCall("{call dev.getEmployeesByDeptId(?,?,?,?)}");
					st.setString(1, employeeList.getFirstName());
					st.setString(2, employeeList.getLastName());
					st.setString(3, employeeList.getEmail());
					st.setString(4, employeeList.getPhoneNumber());
					st.setString(5, employeeList.getHireDate());
					st.setString(6, employeeList.getJobId());
					st.setInt(7, employeeList.getSalary());
					// st.setInt(8, employeeList.getCommisionPct());
					st.setInt(8, employeeList.getManagerId());
					st.setInt(9, employeeList.getDepartmentId());
					st.registerOutParameter(10, java.sql.Types.VARCHAR);
					st.registerOutParameter(11, java.sql.Types.DOUBLE);
					st.registerOutParameter(12, java.sql.Types.VARCHAR);
					st.execute();
					empId = st.getString(10);
					errorCode = (int) st.getLong(11);
					errorDesc = st.getString(12);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setEmpId(empId);
		response.setErrorCode(errorCode);
		response.setErrorDesc(errorDesc);

		return response;
	}

	public EmployeeDetailsResponse getEmployeeDetails(String empId) {
		EmployeeDetailsResponse response = new EmployeeDetailsResponse();

		String query = "select ee.employee_id,ee.first_name || ' ' || ee.last_name,ee.email,ee.phone_number,ee.salary,jj.job_title,dd.department_name from dev.employees ee, dev.jobs jj, dev.departments dd where ee.job_id = jj.job_id and ee.department_id = dd.department_id  and ee.employee_id ="
				+ empId;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection conn = null;
			try {
				conn = ConnectionClass.getEDBConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);

			while (rs.next()) {
				response.setEmpId(rs.getString(1));
				response.setName(rs.getString(2));
				response.setEmail(rs.getString(3));
				response.setPhone(rs.getString(4));
				response.setSalary(rs.getFloat(5));
				response.setJobName(rs.getString(6));
				response.setDepartmentName(rs.getString(7));

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return response;
	}

	public BaseOutput removeEmployee(String empId) {
		BaseOutput response = new BaseOutput();
		int errorCode = 0;
		String errorDesc = "Success";
		String query = "delete from dev.employees ee where ee.employee_id = " + empId;
		System.out.print(empId + "   ");

		try {
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			cstmt.executeQuery(query);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.setErrorCode(errorCode);
		response.setErrorDesc(errorDesc);
		return response;

	}

	public BaseOutput freezeEmployee(String empId) {
		BaseOutput response = new BaseOutput();
		int errorCode = 0;
		String errorDesc = "Success";
		String query = "update dev.employees ee set ee.end_date = to_date(sysdate, 'DD/MM/RRRR') where ee.employee_id ="
				+ empId;

		try {
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(query);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.setErrorCode(errorCode);
		response.setErrorDesc(errorDesc);

		return response;
	}

	public static List<Double> sumOfSalary(String id, String wise) {

		List<Double> totalSalary = new ArrayList<>();
		// List<JobDetails> testRet= new ArrayList<JobDetails>(); testRet=empId("2500");

		String query = "select  e.salary from dev.employees e where " + wise + "= " + "'" + id + "'";

		try {

			// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			try {
				conn = ConnectionClass.getEDBConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				totalSalary.add(rs.getDouble(1));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return totalSalary;

	}

	public List<JobDetails> jobDetails(String salary) {

		List<JobDetails> totalSalary = new ArrayList<>();

		String query = "select j.min_salary, j.max_salary,  j.job_title from dev.jobs j where j.min_salary > " + "'"
				+ salary + "'" /* + "  order by j.max_salary desc" */;

		try {

			// DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			try {
				conn = ConnectionClass.getEDBConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				JobDetails obj = new JobDetails();
				obj.setMinSalary(rs.getDouble(1));
				obj.setMaxSalary(rs.getDouble(2));
				obj.setJobId(rs.getString(3));
				totalSalary.add(obj);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return totalSalary;

	}

	public List<Integer> getEmpIdAccToSalary(String salary) {
		List<Integer> response = new ArrayList<>();
		String query = "select e.employee_id from  dev.employees e  where e.salary > " + "'" + salary + "'";
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			try {
				conn = ConnectionClass.getEDBConnection();

				Statement cstmt = conn.createStatement();
				ResultSet rs = cstmt.executeQuery(query);
				while (rs.next()) {
					response.add(rs.getInt(1));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public Double getEmpSalary(String empId) {
		Double salary = 0D;

		String query = "select e.salary from dev.employees e where e.employee_id = " + "'" + empId + "'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				salary = rs.getDouble(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return salary;
	}

	public DepartmentDetailsResponse getDeptDetails(String deptId) {
		DepartmentDetailsResponse response = new DepartmentDetailsResponse();
		String query = "select d.department_id,d.department_name,d.manager_id,l.street_address,l.postal_code,l.city,l.state_province,l.country_id from dev.departments d, dev.locations l where l.location_id = d.location_id and d.department_id ="
				+ "'" + deptId + "'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				response.setDeptId(rs.getInt(1));
				response.setDepartmentName(rs.getString(2));
				response.setManagerId(rs.getInt(3));
				response.setAddress(rs.getString(4));
				response.setPinCode(rs.getString(5));
				response.setCity(rs.getString(6));
				response.setState(rs.getString(7));
				response.setCountryCode(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	public static char checkTableExistence(String tableName) {

		char flag = 'F';
		String response = "";

		String query = "select table_name from user_tables where LOWER(table_name)= LOWER('" + tableName + "')";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				response = rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (response != "") {
			flag = 'T';
		}

		return flag;
	}

	public static BaseOutput createTable(String tableName, String rows) {
		Long errorCode = 0L;
		String errorDesc = "";
		BaseOutput bs = new BaseOutput();
		System.out.println("The Table Name -->  " + tableName);
		System.out.println("The Table Columns -->  " + rows);

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;
			if (conn != null) {

				try {
					st = conn.prepareCall("{call dev.createTable_withColumnType(?,?,?,?)}");
					// st = conn.prepareCall("{call dev.getEmployeesByDeptId(?,?,?,?)}");
					st.setString(1, tableName);
					st.setString(2, rows);
					st.registerOutParameter(3, java.sql.Types.DOUBLE);
					st.registerOutParameter(4, java.sql.Types.VARCHAR);
					st.execute();

					errorCode = st.getLong(3);
					errorDesc = st.getString(4);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bs.setErrorCode(errorCode.intValue());
		bs.setErrorDesc(errorDesc);
		return bs;
	}

	public BaseOutput insertDataInTable(String tableName, String values) {
		BaseOutput output = new BaseOutput();
		int errorCode = 0;
		String errorDesc = "";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;
			if (conn != null) {

				try {
					st = conn.prepareCall("{call dev.INSERTDATAINTOTABLE_ColumnWise(?,?,?,?)}");
					// st = conn.prepareCall("{call dev.getEmployeesByDeptId(?,?,?,?)}");
					st.setString(1, tableName);
					st.setString(2, values);
					st.registerOutParameter(3, java.sql.Types.DOUBLE);
					st.registerOutParameter(4, java.sql.Types.VARCHAR);
					st.execute();

					errorCode = st.getInt(3);
					errorDesc = st.getString(4);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		output.setErrorCode(errorCode);
		output.setErrorDesc(errorDesc);
		return output;

	}

	public String insertDocDetails(String fileName, String fileLocation) {
		String errorDesc = null;
		int errorCode = 0;
		String docId = "";
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;

			if (conn != null) {
				try {
					st = conn.prepareCall("{call dev.insertDocDetails(?,?,?,?,?)}");
					st.setString(1, fileName);
					st.setString(2, fileLocation);
					st.registerOutParameter(3, java.sql.Types.VARCHAR);
					st.registerOutParameter(4, java.sql.Types.DOUBLE);
					st.registerOutParameter(5, java.sql.Types.VARCHAR);
					st.execute();
					docId = st.getString(3);
					errorCode = st.getInt(4);
					errorDesc = st.getString(5);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return docId;
	}

	public String getClobTableData(String tableName) {

		BaseOutput output = new BaseOutput();

		int errorCode = 0;
		String errorDesc = "";
		String clobSting = "";
		java.sql.Clob clobOut = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;

			try {
				st = conn.prepareCall("{call dev.extractClobDataForTables(?,?,?,?)}");
				st.setString(1, tableName);
				st.registerOutParameter(2, java.sql.Types.CLOB);
				st.registerOutParameter(3, java.sql.Types.DOUBLE);
				st.registerOutParameter(4, java.sql.Types.VARCHAR);
				st.execute();
				clobOut = st.getClob(2);

				clobSting = Utility.convertCLOBToString(clobOut);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(clobSting);

		return clobSting;

	}

	public List<String> getNamesOfDBTables(String schema) {

		List<String> DBTables = new ArrayList<>();
		String tableName = "";
		String query = "SELECT T.object_name     FROM all_objects T    WHERE object_type IN ('TABLE')   AND T.owner = '"
				+ schema + "'";
		System.out.println(query);

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				tableName = rs.getString(1);
				DBTables.add(tableName);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return DBTables;

	}

	public CountryGDPResponse getYearWiseGDPofWorld(String year) {
		CountryGDPResponse response = new CountryGDPResponse();

		List<CountryGDPList> objList = new ArrayList<>();
		int errorCode = 0;
		String errorDesc = "Success";

		String query = "";

		if (year.equals("2018"))

			query = "select y.country_name, y.country_code, y.indicator_code, y.year_2018 from dev.year_wise_gdp y ";

		if (year.equals("2019"))

			query = "select y.country_name, y.country_code, y.indicator_code, y.year_2019 from dev.year_wise_gdp y ";
		if (year.equals("2020"))

			query = "select y.country_name, y.country_code, y.indicator_code, y.year_2020 from dev.year_wise_gdp y ";

		if (year.equals("2021"))

			query = "select y.country_name, y.country_code, y.indicator_code, y.year_2021 from dev.year_wise_gdp y ";

		System.out.println(query);

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				CountryGDPList obj = new CountryGDPList();
				obj.setCountryName(rs.getString(1));
				obj.setCountryCode(rs.getString(2));
				obj.setUnit(rs.getString(3));
				obj.setYear(year);
				obj.setGpd(rs.getDouble(4));
				objList.add(obj);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCountryGDPList(objList);
		response.setErrorCode(errorCode);
		response.setErrorDesc(errorDesc);
		return response;
	}

	public String getStoredFileLocation(String docId) {

		String fileLocation = "";
		String query = "select t.file_location from DOCUMENT_DETAILS t where t.doc_id = '" + docId + "'";
		System.out.println(query);

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				fileLocation = rs.getString(1);

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileLocation;

	}

	public static String getDocLocationWithDocId(String docId) {

		String fileLocation = "";

		String query = "select dd.file_location from dev.document_details dd where dd.doc_id = '" + docId + "'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				fileLocation = rs.getString(1);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileLocation;
	}

	public static String getDocLocationWithDocId2(String docId) {

		String fileLocation = "";

		String fieldSeperator = AppProperties.strCHAR164;
		ARRAY inputData = null;
		List<Property> propertyList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			Property prop = new Property();
			prop.setParamName("CheckParamName");
			prop.setParamValue("checkParamValue");
			propertyList.add(prop);

		}
		Struct[] struct = new Struct[propertyList.size()];

		System.out.println(propertyList);
		TRECORDTAB PROPERTY = new TRECORDTAB(null);

		String query = "select dd.file_location from dev.document_details dd where dd.doc_id = '" + docId + "'";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;

			conn = ConnectionClass.getEDBConnection();
			ArrayDescriptor objArrayDesc = null;
			objArrayDesc = ConnectionClass.getDescriptor("UTIL.TRECORDTAB", conn);

			for (Property property : propertyList) {
				PROPERTY.set(PROPERTY.getCount(), property.getParamName() + fieldSeperator + property.getParamValue());
				PROPERTY.extend(1, PROPERTY.getCount());
			}
			PROPERTY.delete(PROPERTY.getCount());

			inputData = ConnectionClass.getARRAY(objArrayDesc, conn, PROPERTY.toArray());

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileLocation;
	}

	public static String getDocLocationWithDocId4(List<Property> property) {

		try {
			Object[] reportArray = new Object[3];
			Struct[] struct = new Struct[property.size()];
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;

			conn = ConnectionClass.getEDBConnection();

			int arrayIndex = 0;
			for (Property data : property) {
				reportArray[0] = data.getParamName();
				reportArray[1] = data.getParamValue();

				struct[arrayIndex++] = conn.createStruct("R_REPORT_OBJECT", reportArray);
			}
			CallableStatement cstmt = null;

			Array reportsArray = ((OracleConnection) conn).createOracleArray("T_REPORT_TABLE", struct);
			cstmt = conn.prepareCall(null);

			cstmt.setArray(1, reportsArray);

			cstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "OK";
	}

	public String getLanguageCode(String language) {

		List<String> DBTables = new ArrayList<>();
		String languageCode = "";
		String query = "select lc.alpha2 from dev.language_codes lc where Upper(lc.language) =upper('" + language
				+ "')";
		System.out.println(query);

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			Statement cstmt = conn.createStatement();
			ResultSet rs = cstmt.executeQuery(query);
			while (rs.next()) {
				languageCode = rs.getString(1);
				if (languageCode.equals("")) {
					return "This language is not present in our local DB";
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return languageCode;

	}

	public String insertApiLogs(String url, String request, String response) {

		BaseOutput output = new BaseOutput();

		double errorCode = 0;
		String errorDesc = "";
		String clobSting = "";
		java.sql.Clob clobOut = null;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;

			try {
				st = conn.prepareCall("{call dev.insert_api_data(?,?,?,?,?)}");
				st.setString(1, url);
				st.setString(2, request);
				st.setString(3, response);

				st.registerOutParameter(4, java.sql.Types.DOUBLE);
				st.registerOutParameter(5, java.sql.Types.VARCHAR);
				st.execute();

				errorCode = st.getDouble(4);
				errorDesc = st.getString(5);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(clobSting);

		return errorDesc;

	}
}