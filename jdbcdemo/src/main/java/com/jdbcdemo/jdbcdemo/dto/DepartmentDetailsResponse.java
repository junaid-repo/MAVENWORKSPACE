package com.jdbcdemo.jdbcdemo.dto;

public class DepartmentDetailsResponse extends BaseOutput {

	int deptId = 0;
	String departmentName="";
	int managerId = 0;
	String address = "";
	String pinCode = "";
	String city = "";
	String state = "";
	String countryCode = "";
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "DepartmentDetailsResponse [deptId=" + deptId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", address=" + address + ", pinCode=" + pinCode + ", city=" + city + ", state=" + state
				+ ", countryCode=" + countryCode + "]";
	}
	
	
	

}
