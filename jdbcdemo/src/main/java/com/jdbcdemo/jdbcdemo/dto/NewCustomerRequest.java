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

	public void setName(String name) {
		this.name = name;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Float creditLimit) {
		this.creditLimit = creditLimit;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}

	@Override
	public String toString() {
		return "NewCustomerRequest [name=" + name + ", type=" + type + ", address=" + address + ", website=" + website
				+ ", creditLimit=" + creditLimit + ", customerContact=" + customerContact + "]";
	}

	

}
