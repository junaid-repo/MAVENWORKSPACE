package com.jdbcdemo.jdbcdemo.dto;

public class CreateChatUserRequest {
	private String firstName = "";
	private String lastName = "";
	private String gender = "";
	private String dob = "";
	private String password="";
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CreateChatUser [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob="
				+ dob + "]";
	}
	
}
