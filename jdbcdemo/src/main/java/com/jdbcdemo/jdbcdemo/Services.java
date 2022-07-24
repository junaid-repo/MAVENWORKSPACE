package com.jdbcdemo.jdbcdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.jdbcdemo.jdbcdemo.coreCall.BaseServicesCall;
import com.jdbcdemo.jdbcdemo.coreCall.CoreServiceCall;
import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.BulkEmployeesResponse;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeResponse;
import com.jdbcdemo.jdbcdemo.interfaces.CreateEmployeeInBulkIF;
import com.jdbcdemo.jdbcdemo.interfaces.IFN01;
import com.jdbcdemo.jdbcdemo.interfaces.IServices;

@Component
public class Services implements IServices {
	@Autowired
	CoreServiceCall bs;

	public EmployeeDetailsResponse getEmployeeLists(String empId) {

		EmployeeDetailsResponse response = new EmployeeDetailsResponse();
		CoreServiceCall bs = new CoreServiceCall();
		response = bs.getEmployeeLists(empId);

		return response;
	}

	@Override
	public InsertEmployeeResponse insertNewEmployee(InsertEmployeeList request) {
		// InsertEmployeeList employeeList = new ArrayList<>();
		InsertEmployeeResponse response = new InsertEmployeeResponse();
		// CoreServiceCall bs = new CoreServiceCall();
		String empId = "";
		response = bs.insertNewEmployee(request);

		return response;

	}

	@Override
	public EmployeeDetailsResponse getEmployeeDetails(String empId) {
		// TODO Auto-generated method stub
		EmployeeDetailsResponse response = new EmployeeDetailsResponse();

		response = bs.getEmployeeDetails(empId);

		return response;
	}

	@Override
	public BaseOutput removeEmployee(String empId) {
		BaseOutput response = new BaseOutput();
		response = bs.removeEmployee(empId);
		return response;
	}

	public BaseOutput freezeEmployee(String empId) {

		IFN01 fo = (String emId) -> {
			CoreServiceCall bss = new CoreServiceCall();
			BaseOutput response = new BaseOutput();
			response = bss.freezeEmployee(empId);

			return response;

		};

		return fo.freezeEmployee(empId);

	}

	public BulkEmployeesResponse createBulkEmployee(List<InsertEmployeeList> employeeList) {
		BulkEmployeesResponse response = new BulkEmployeesResponse();
		CreateEmployeeInBulkIF cf = (List<InsertEmployeeList> empList) -> {

			CoreServiceCall bst = new CoreServiceCall();
			InsertEmployeeResponse empResponse = new InsertEmployeeResponse();
			List<InsertEmployeeResponse> empList5 = new ArrayList<>();
			for (InsertEmployeeList empList3 : empList.stream().toList()) {

				empResponse = bst.insertNewEmployee(empList3);

				empList5.add(empResponse);
				response.setNewEmployeesResponse(empList5);

			}

			return response;
		};

		return cf.createBulkEmployees(employeeList);

	}

}