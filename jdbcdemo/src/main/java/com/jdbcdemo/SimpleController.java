package com.jdbcdemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.ExcelProject.CSVReader;
import com.demo.ExcelProject.ImportURL;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jdbcdemo.jdbcdemo.Services;
import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.dto.BulkEmployeesResponse;
import com.jdbcdemo.jdbcdemo.dto.EmployeeBulkDeleteRequest;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsRequest;
import com.jdbcdemo.jdbcdemo.dto.EmployeeDetailsResponse;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeList;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeRequest;
import com.jdbcdemo.jdbcdemo.dto.InsertEmployeeResponse;
import com.jdbcdemo.jdbcdemo.interfaces.IServices;

@RestController
public class SimpleController {
	@Autowired
	IServices serv;

	@RequestMapping(value = "jdbcDemo", method = RequestMethod.GET)
	ResponseEntity<BaseOutput> simpleControllerDemo() {

		BaseOutput bs = new BaseOutput();
		bs.setErrorCode(133);
		bs.setErrorDesc("Success");
		return new ResponseEntity<BaseOutput>(bs, HttpStatus.OK);
	}

	@RequestMapping(value = "getEmployeeLists", method = RequestMethod.GET)
	ResponseEntity<EmployeeDetailsResponse> getEmpDetails(@RequestBody EmployeeDetailsRequest empOb) {

		// System.out.println(empId);
		String empId = empOb.getDeptId();

		EmployeeDetailsResponse output = new EmployeeDetailsResponse();
		if (empId == null || empId == "") {

			output.setErrorDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());
			output.setErrorCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<EmployeeDetailsResponse>(output, HttpStatus.BAD_REQUEST);
		}
		// IServices serv = new Services();
		try {
			output = serv.getEmployeeLists(empId);
		} catch (Exception e) {
			output.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			output.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<EmployeeDetailsResponse>(output, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		output.setErrorDesc(HttpStatus.OK.getReasonPhrase());
		output.setErrorCode(HttpStatus.OK.value());

		return new ResponseEntity<EmployeeDetailsResponse>(output, HttpStatus.OK);

	}

	@RequestMapping(value = "addEmployee", method = RequestMethod.POST)
	ResponseEntity<InsertEmployeeResponse> insertNewEmployee(@RequestBody InsertEmployeeList request) {

		InsertEmployeeResponse response = new InsertEmployeeResponse();

		try {
			response = serv.insertNewEmployee(request);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			// return new ResponseEntity<InsertEmployeeResponse>(response,
			// HttpStatus.INTERNAL_SERVER_ERROR);
		}

		String location = ServletUriComponentsBuilder
				.fromHttpUrl(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString() + "/getEmployeeDetails")
				.path("/{id}").buildAndExpand(response.getEmpId()).toUri().toString();

		System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());

		response.setErrorDesc(HttpStatus.CREATED.getReasonPhrase());
		response.setErrorCode(HttpStatus.CREATED.value());
		response.setEmpId(response.getEmpId());
		response.setUrl(location);
		// return ResponseEntity.created(location).build();
		return new ResponseEntity<InsertEmployeeResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "getEmployeeDetails/{empId}", method = RequestMethod.GET)
	@Produces(MediaType.APPLICATION_XML)
	ResponseEntity<EmployeeDetailsResponse> getEmployeeDetails(@PathVariable String empId) {
		EmployeeDetailsResponse response = new EmployeeDetailsResponse();
		if (empId == null || empId == "") {

			response.setErrorDesc(HttpStatus.BAD_REQUEST.getReasonPhrase());
			response.setErrorCode(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<EmployeeDetailsResponse>(response, HttpStatus.BAD_REQUEST);
		}
		try {
			response = serv.getEmployeeDetails(empId);
			if (response.getName() == "" || response.getName() == null) {
				response.setErrorDesc(HttpStatus.NOT_FOUND.getReasonPhrase());
				response.setErrorCode(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<EmployeeDetailsResponse>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<EmployeeDetailsResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setErrorDesc(HttpStatus.OK.getReasonPhrase());
		response.setErrorCode(HttpStatus.OK.value());

		return new ResponseEntity<EmployeeDetailsResponse>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "deleteUser/{empId}", method = RequestMethod.DELETE)
	ResponseEntity<BaseOutput> removeEmployee(@PathVariable String empId) {
		BaseOutput response = new BaseOutput();

		try {
			response = serv.removeEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			System.out.println("Catching exceptions");
			return new ResponseEntity<BaseOutput>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.setErrorDesc(HttpStatus.OK.getReasonPhrase());
		response.setErrorCode(HttpStatus.OK.value());

		return new ResponseEntity<BaseOutput>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "freezeEmployee/{empId}", method = RequestMethod.POST)
	ResponseEntity<BaseOutput> freezeEmployee(@PathVariable String empId) {
		BaseOutput response = new BaseOutput();
		Services serv = new Services();
		response = serv.freezeEmployee(empId);

		return new ResponseEntity<BaseOutput>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "createBulkEmployee", method = RequestMethod.POST)
	ResponseEntity<BulkEmployeesResponse> createBulkEmployee(@RequestBody InsertEmployeeRequest employeeList) {
		// BaseOutput response = new BaseOutput();
		BulkEmployeesResponse response = new BulkEmployeesResponse();
		Services serv = new Services();
		try {
			response = serv.createBulkEmployee(employeeList.getEmployeeList());
		} catch (Exception e) {
			response.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		List<InsertEmployeeResponse> newEmpRespnse = new ArrayList<>();
		newEmpRespnse = response.getNewEmployeesResponse();
		List<InsertEmployeeResponse> newEmployeesResponse = new ArrayList<>();

		for (InsertEmployeeResponse ier : newEmpRespnse) {
			String location = ServletUriComponentsBuilder
					.fromHttpUrl(
							ServletUriComponentsBuilder.fromCurrentContextPath().toUriString() + "/getEmployeeDetails")
					.path("/{id}").buildAndExpand(ier.getEmpId()).toUri().toString();

			System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
			InsertEmployeeResponse obj = new InsertEmployeeResponse();

			obj.setErrorDesc(HttpStatus.CREATED.getReasonPhrase());
			obj.setErrorCode(HttpStatus.CREATED.value());
			obj.setEmpId(ier.getEmpId());
			obj.setUrl(location);
			newEmployeesResponse.add(obj);
		}
		response.setNewEmployeesResponse(newEmployeesResponse);
		// return ResponseEntity.created(location).build();

		return new ResponseEntity<BulkEmployeesResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "importBulkUsers", method = RequestMethod.POST)
	ResponseEntity<BulkEmployeesResponse> importUsers(@RequestBody ImportURL fileLocation) {
		// BaseOutput response = new BaseOutput();
		String loc = "C:\\\\Users\\\\junai\\\\Downloads\\\\BulkEmployees.csv";
		CSVReader rd = new CSVReader();
		String jsonString = "";
		try {
			jsonString = rd.csvRead(fileLocation.getFileLocation());
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		List<InsertEmployeeList> arList = new ArrayList<>();
		try {
			arList = mapper.readValue(jsonString, new TypeReference<List<InsertEmployeeList>>() {
			});
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BulkEmployeesResponse response = new BulkEmployeesResponse();
		Services serv = new Services();
		try {
			response = serv.createBulkEmployee(arList);
		} catch (Exception e) {
			response.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}

		List<InsertEmployeeResponse> newEmpRespnse = new ArrayList<>();
		newEmpRespnse = response.getNewEmployeesResponse();
		List<InsertEmployeeResponse> newEmployeesResponse = new ArrayList<>();

		for (InsertEmployeeResponse ier : newEmpRespnse) {
			String location = ServletUriComponentsBuilder
					.fromHttpUrl(
							ServletUriComponentsBuilder.fromCurrentContextPath().toUriString() + "/getEmployeeDetails")
					.path("/{id}").buildAndExpand(ier.getEmpId()).toUri().toString();

			System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().toUriString());
			InsertEmployeeResponse obj = new InsertEmployeeResponse();

			obj.setErrorDesc(HttpStatus.CREATED.getReasonPhrase());
			obj.setErrorCode(HttpStatus.CREATED.value());
			obj.setEmpId(ier.getEmpId());
			obj.setUrl(location);
			newEmployeesResponse.add(obj);
		}
		response.setNewEmployeesResponse(newEmployeesResponse);
		// return ResponseEntity.created(location).build();

		return new ResponseEntity<BulkEmployeesResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "deleteBulkUser", method = RequestMethod.POST)
	ResponseEntity<BaseOutput> removeBulkEmployee(@RequestBody ImportURL fileLocation) {
		BaseOutput response = new BaseOutput();
		CSVReader rd = new CSVReader();
		String jsonString = "";
		try {
			jsonString = rd.csvRead(fileLocation.getFileLocation());
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		ObjectMapper mapper = new ObjectMapper();
		List<EmployeeBulkDeleteRequest> arList = new ArrayList<>();
		try {
			arList = mapper.readValue(jsonString, new TypeReference<List<EmployeeBulkDeleteRequest>>() {
			});
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			for (EmployeeBulkDeleteRequest empList : arList) {
				response = serv.removeEmployee(empList.getEmpId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<BaseOutput>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.setErrorDesc(HttpStatus.OK.getReasonPhrase());
		response.setErrorCode(HttpStatus.OK.value());

		return new ResponseEntity<BaseOutput>(response, HttpStatus.OK);
	}

}