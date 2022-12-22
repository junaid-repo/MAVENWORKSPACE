package com.chat.chatapp.dto;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;

public class CUserResponse extends BaseOutput {

	private String userName = "";

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "CUserResponse [userName=" + userName + "]";
	}

}
