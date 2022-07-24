package com.jdbcdemo.jdbcdemo.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmployeeBulkDeleteRequest extends BaseOutput {
	String empId = "";

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public String toString() {
		return "EmployeeBulkDeleteRequest [empId=" + empId + ", getEmpId()=" + getEmpId() + "]";
	}
	
}
