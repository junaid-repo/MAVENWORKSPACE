package com.jdbcdemo.jdbcdemo.dto;

public class CustomerContact {

	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String phoneNumber = "";
	private String customerId = "";
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getCustomerId() {
		return customerId;
	}
	@Override
	public String toString() {
		return "CustomerContact [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", customerId=" + customerId + "]";
	}

	

	
	

}
