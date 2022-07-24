package com.jdbcdemo.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.List;

public class BulkEmployeesResponse extends BaseOutput {
	
	List<InsertEmployeeResponse> newEmployeesResponse= new ArrayList<>();

	public List<InsertEmployeeResponse> getNewEmployeesResponse() {
		return newEmployeesResponse;
	}

	public void setNewEmployeesResponse(List<InsertEmployeeResponse> newEmployeesResponse) {
		this.newEmployeesResponse = newEmployeesResponse;
	}

	@Override
	public String toString() {
		return "BulkEmployeesResponse [newEmployeesResponse=" + newEmployeesResponse + ", getNewEmployeesResponse()="
				+ getNewEmployeesResponse() + ", getErrorCode()=" + getErrorCode() + ", getErrorDesc()="
				+ getErrorDesc() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + "]";
	}

	

}
