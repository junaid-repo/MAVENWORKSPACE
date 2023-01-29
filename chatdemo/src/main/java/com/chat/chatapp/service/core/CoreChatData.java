package com.chat.chatapp.service.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.chat.chatapp.dto.ChatRequestDto;

import connection.ConnectionClass;
import utility.Utility;

@Component
public class CoreChatData {

	public Map<String, Object> addChatData(ChatRequestDto crd) {

		Map<String, Object> retMap = new HashMap<>();

		String fromUser = crd.getFromUser();
		String toUser = crd.getToUser();
		String msg = crd.getMsg();

		String errorDesc = "";
		Integer errorCode = 0;

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;

			st = conn.prepareCall("{call  ot.pkg_chat_maintain.updatechatmessages(?,?,?,?,?)}");
			st.setString(1, fromUser);
			st.setString(2, toUser);
			st.setString(3, msg);
			st.registerOutParameter(4, java.sql.Types.INTEGER);
			st.registerOutParameter(5, java.sql.Types.VARCHAR);
			st.execute();

			errorCode = st.getInt(4);
			errorDesc = st.getString(5);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retMap.put("errorCode", errorCode);
		retMap.put("errorDesc", errorDesc);
		return retMap;

	}

	public Map<String, Object> getChatData(String fromUser, String toUser, String date) {
		java.sql.Clob clobOut = null;
		String chatData = null;
		Map<String, Object> retMap = new HashMap<>();
		int errorCode = 0;
		String errorDesc = "Success";
		String clobSting = null;
		String primaryConcat = "~~";
		String secondaryConcat = "@@";
		String tertConcat = "##";

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = null;
			conn = ConnectionClass.getEDBConnection();
			CallableStatement st = null;

			st = conn.prepareCall("{call ot.pkg_chat_maintain.getchatmessageDetails(?,?,?,?,?,?)}");
			st.setString(1, fromUser);
			st.setString(2, toUser);
			st.setString(3, date);

			st.registerOutParameter(4, java.sql.Types.CLOB);
			st.registerOutParameter(5, java.sql.Types.DOUBLE);
			st.registerOutParameter(6, java.sql.Types.VARCHAR);
			st.execute();
			clobOut = st.getClob(4);

			if (clobOut != null)
				chatData = Utility.convertCLOBToString(clobOut);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retMap.put("clobData", clobSting);
		retMap.put("primaryConcat", primaryConcat);
		retMap.put("secondaryConcat", secondaryConcat);
		retMap.put("tertConcat", tertConcat);
		retMap.put("errorCode", errorCode);
		retMap.put("errorDesc", errorDesc);

		return retMap;
	}

}
