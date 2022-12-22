package com.system.users.dto;


public class UserResponse extends BaseOutput {

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
