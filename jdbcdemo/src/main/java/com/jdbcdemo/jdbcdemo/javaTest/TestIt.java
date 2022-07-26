package com.jdbcdemo.jdbcdemo.javaTest;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.ConnectionClass;
import oracle.jdbc.OracleType;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import utility.TRECORDTAB;

public class TestIt {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		/*
		 * String details =
		 * "103~~Alexander Hunold~~9000##104~~Bruce Ernst~~6000##105~~David Austin~~4800##106~~Valli Pataballa~~4800##107~~Diana Lorentz~~4200##"
		 * ;
		 * 
		 * String D1[] = details.split("##"); for (int i = 0; i < D1.length; i++) {
		 * 
		 * String D2[] = D1[i].split("~~");
		 * 
		 * System.out.println(D2[0]);
		 * 
		 * }
		 */

		/*
		 * String query =
		 * "select ee.employee_id,ee.first_name || ' ' || ee.last_name,ee.email,ee.phone_number,ee.salary,jj.job_title,dd.department_name from dev.employees ee, dev.jobs jj, dev.departments dd where ee.job_id = jj.job_id and ee.department_id = dd.department_id  and ee.employee_id = 110"
		 * ;
		 * 
		 * try { DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 * 
		 * Connection conn = null; try { conn = ConnectionClass.getEDBConnection(); }
		 * catch (ClassNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * Statement cstmt = conn.createStatement(); ResultSet rs =
		 * cstmt.executeQuery(query); while (rs.next()) {
		 * System.out.println(rs.getString(1)); System.out.println(rs.getString(2)); } }
		 * catch (Exception ex) { ex.printStackTrace(); }
		 */
		TRECORDTAB tr = new TRECORDTAB();
		tr.setParamData("param1");

		TRECORDTAB[] trecordTab = new TRECORDTAB[] { tr };

		// ParamHolder[] paramHolders = null;

		try {
			Connection con = ConnectionClass.getEDBConnection();
			CallableStatement stmnt = con.prepareCall("{ call testRecordTab(?) }");
	
			//ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("TRECORDTAB", con);
			ArrayDescriptor descriptor = ArrayDescriptor.createDescriptor("TRECORDTAB", con);
			
			Array array = new ARRAY(descriptor, con, trecordTab);
			stmnt.setArray(1, array);
			// stmnt.registerOutParameter(2,OracleType.VARCHAR2,"p_out_var"); //Register any
			// output variable if your procedure returns any thing.
			//stmnt.execute(); // this will take the Array of ParamHolder straight to the DB for processing.
			// String result = stmnt.getString(2); //Will fetch yuou the result form the DB
			// to your local String.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
