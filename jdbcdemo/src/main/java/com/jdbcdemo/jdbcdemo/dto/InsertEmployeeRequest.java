package com.jdbcdemo.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.List;

public class InsertEmployeeRequest {
	
	List<InsertEmployeeList> employeeList = new ArrayList<>();
	//String testData="testData";
	public List<InsertEmployeeList> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<InsertEmployeeList> employeeList) {
		this.employeeList = employeeList;
	}
	@Override
	public String toString() {
		return "InsertEmployeeRequest [employeeList=" + employeeList + ", getEmployeeList()=" + getEmployeeList()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

	
	
}
