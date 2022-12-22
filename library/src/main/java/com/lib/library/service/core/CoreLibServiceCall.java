package com.lib.library.service.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import connection.ConnectionClass;

public class CoreLibServiceCall {

	public Map<String, Object> createLibUsers(Map userDetails) {

		Map retMap = new HashMap<>();
		String retCode = "";
		String retError = "";
		String userCode = "";

		String name = (String) userDetails.get("name");
		String gender = (String) userDetails.get("gender");
		String membershipOpted = (String) userDetails.get("membershipType");
		Integer validity = (Integer) userDetails.get("validity");

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			Connection conn = null;

			conn = ConnectionClass.getEDBConnection();

			CallableStatement st = null;
			if (conn != null) {
				st = conn.prepareCall("{call ot.pkg_lib_maintain.create_lib_user(?,?,?,?,?,?,?)}");
				st.setString(1, name);
				st.setString(2, gender);
				st.setString(3, membershipOpted);
				st.setInt(4, validity);
				st.registerOutParameter(5, java.sql.Types.VARCHAR);
				st.registerOutParameter(6, java.sql.Types.VARCHAR);
				st.registerOutParameter(7, java.sql.Types.VARCHAR);
				st.execute();
				userCode = st.getString(5);
				retCode = st.getString(6);
				retError = st.getString(7);

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		if (retCode.equals("0")) {
			retCode = "200";
			retError = "Member Created";

		}
		retMap.put("memberCode", userCode);
		retMap.put("retCode", retCode);
		retMap.put("retMessage", retError);

		return retMap;
	}

	public Map addBook(Map<String, Object> bookDetails) {

		Map<String, Object> response = new HashMap<>();
		String bookName = (String) bookDetails.get("bookName");
		String bookGenere = (String) bookDetails.get("genere");
		Integer count = (Integer) bookDetails.get("count");
		String bookCode = "";
		String bookShelf = "";
		String errorDesc = "";
		Integer errorCode = 0;

		try {

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;
			st = conn.prepareCall("{call ot.pkg_lib_maintain.addBook(?,?,?,?,?,?,?)}");
			st.setString(1, bookName);
			st.setString(2, bookGenere);
			st.setInt(3, count);
			st.registerOutParameter(4, java.sql.Types.VARCHAR);
			st.registerOutParameter(5, java.sql.Types.VARCHAR);
			st.registerOutParameter(6, java.sql.Types.INTEGER);
			st.registerOutParameter(7, java.sql.Types.VARCHAR);
			st.execute();
			bookCode = st.getString(4);
			bookShelf = st.getString(5);
			errorCode = st.getInt(6);
			errorDesc = st.getString(7);

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.put("bookCode", bookCode);
		response.put("boookShelf", bookShelf);
		response.put("errorCode", errorCode);
		response.put("errorDesc", errorDesc);
		return response;
	}
}
