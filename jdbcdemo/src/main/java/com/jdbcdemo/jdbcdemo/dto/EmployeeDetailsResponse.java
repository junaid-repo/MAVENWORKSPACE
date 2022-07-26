package com.jdbcdemo.jdbcdemo.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
public class EmployeeDetailsResponse extends BaseOutput {
	
	
	
	ArrayList<EmployeeDetails> employeeDetails = new ArrayList<>();
	
	String empId="";
	String name="";
	String email="";
	String phone="";
	float salary=0;
	String jobName="";
	String DepartmentName="";
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public ArrayList<EmployeeDetails> getEmployeeDetails() {
		return employeeDetails;
	}
	public void setEmployeeDetails(ArrayList<EmployeeDetails> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}
	@Override
	public String toString() {
		return "EmployeeDetailsResponse [employeeDetails=" + employeeDetails + ", empId=" + empId + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", salary=" + salary + ", jobName=" + jobName
				+ ", DepartmentName=" + DepartmentName + "]";
	}


	
	
	
	
	
	

}
