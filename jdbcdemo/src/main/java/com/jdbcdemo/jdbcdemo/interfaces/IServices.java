package com.jdbcdemo.jdbcdemo.interfaces;

import org.springframework.stereotype.Component;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeResponse;

@Component
public interface IServices {
	
	public EmployeeDetailsResponse getEmployeeLists(String deptId);
	public InsertEmployeeResponse insertNewEmployee(InsertEmployeeList request); 
	public EmployeeDetailsResponse getEmployeeDetails(String empId);
	public BaseOutput removeEmployee(String empId);


}
