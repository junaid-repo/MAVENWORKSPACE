package com.jdbcdemo.jdbcdemo.dto;

public class InsertEmployeeResponse extends BaseOutput{
	
	String empId="";
	String url="";


	public String getEmpId() {
		return empId;
	}


	public void setEmpId(String empId) {
		this.empId = empId;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	public String toString() {
		return "InsertEmployeeResponse [empId=" + empId + ", url=" + url + ", getEmpId()=" + getEmpId() + ", getUrl()="
				+ getUrl() + ", getErrorCode()=" + getErrorCode() + ", getErrorDesc()=" + getErrorDesc()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}


	
	

}
