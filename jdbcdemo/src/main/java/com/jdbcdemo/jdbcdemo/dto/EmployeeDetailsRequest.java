package com.jdbcdemo.jdbcdemo.dto;

public class EmployeeDetailsRequest {
	
	private String deptId="";

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "EmployeeDetailsRequest [deptId=" + deptId + "]";
	}
	
	
	

}
