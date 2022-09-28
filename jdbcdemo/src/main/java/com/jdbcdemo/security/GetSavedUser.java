package com.jdbcdemo.security;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.jdbcdemo.jdbcdemo.dto.CreateChatUserResponse;

import connection.ConnectionClass;

public class GetSavedUser {

	Map<String, Object> getSavedUser(String userCode) {
		Map<String, Object> retMap = new HashMap<>();


		String psd = "";

		String errorDesc = "Success";

		int errorCode = 0;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;

			try {
				st = conn.prepareCall("{call ot.dncd(?,?,?,?)}");
				st.setString(1, userCode);
				st.registerOutParameter(2, java.sql.Types.VARCHAR);
				st.registerOutParameter(3, java.sql.Types.INTEGER);
				st.registerOutParameter(4, java.sql.Types.VARCHAR);
				st.execute();

				psd = st.getString(2);
				errorDesc = st.getString(3);
				errorCode = st.getInt(4);
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

		retMap.put("userCode", userCode);
		retMap.put("psd", psd);
		retMap.put("errorCode", errorCode);
		retMap.put("errorDesc", errorDesc);

		return retMap;
	}

}
