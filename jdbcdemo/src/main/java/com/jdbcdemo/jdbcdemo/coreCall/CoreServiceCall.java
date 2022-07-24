package com.jdbcdemo.jdbcdemo.coreCall;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetails;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeResponse;
import com.jdbcdemo.jdbcdemo.properties.PropertyClass;

import connection.ConnectionClass;
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
		System.out.print(empId+"   ");

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
		String errorDesc="Success";
		String query="update dev.employees ee set ee.end_date = to_date(sysdate, 'DD/MM/RRRR') where ee.employee_id ="+empId;
		
		try {
			Connection conn=null;
			conn=ConnectionClass.getEDBConnection();
			Statement stmt = conn.createStatement();
			stmt.execute(query);
					
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		response.setErrorCode(errorCode);
		response.setErrorDesc(errorDesc);
		
		return response;
	}
	
}