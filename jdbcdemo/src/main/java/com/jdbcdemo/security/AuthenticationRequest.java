package com.jdbcdemo.security;

public class AuthenticationRequest {

	private String userName = "";
	private String password = "";

	public AuthenticationRequest() {

		// TODO Auto-generated constructor stub
	}

	public AuthenticationRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
