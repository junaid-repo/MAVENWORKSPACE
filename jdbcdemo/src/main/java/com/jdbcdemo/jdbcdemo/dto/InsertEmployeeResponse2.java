package com.jdbcdemo.jdbcdemo.dto;

public class InsertEmployeeResponse2 extends BaseOutput{
	
	String empId="";
	Double salary=0D;
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "InsertEmployeeResponse [empId=" + empId + ", url=" + url + ", salary=" + salary + ", getEmpId()="
				+ getEmpId() + ", getUrl()=" + getUrl() + ", getSalary()=" + getSalary() + ", getErrorCode()="
				+ getErrorCode() + ", getErrorDesc()=" + getErrorDesc() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}


	

	
	

}
