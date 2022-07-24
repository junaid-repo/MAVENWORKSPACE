package com.jdbcdemo.jdbcdemo.interfaces;

import java.util.List;

import com.jdbcdemo.jdbcdemo.dto.BulkEmployeesResponse;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;

public interface CreateEmployeeInBulkIF {
	
	BulkEmployeesResponse createBulkEmployees(List<InsertEmployeeList> employeeList);

}
