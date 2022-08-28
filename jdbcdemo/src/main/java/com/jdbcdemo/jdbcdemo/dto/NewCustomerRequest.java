package com.jdbcdemo.jdbcdemo.dto;

public class NewCustomerRequest {

	private String name = "";
	private String type = "";
	private String address = "";
	private String website = "";
	private Float creditLimit = 0F;

	CustomerContact customerContact;

	public String getName() {
		return name;
	}

	public String getWebsite() {
		return website;
	}

	public Float getCreditLimit() {
		return creditLimit;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "NewCustomerRequest [name=" + name + ", type=" + type + ", address=" + address + ", website=" + website
				+ ", creditLimit=" + creditLimit + ", customerContact=" + customerContact + "]";
	}

}
