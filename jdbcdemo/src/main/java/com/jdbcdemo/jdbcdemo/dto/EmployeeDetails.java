package com.jdbcdemo.jdbcdemo.dto;

public class EmployeeDetails {
	
	private String empId;
	private String name;
	private long salary;
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
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empId=" + empId + ", name=" + name + ", salary=" + salary + ", getEmpId()="
				+ getEmpId() + ", getName()=" + getName() + ", getSalary()=" + getSalary() + "]";
	}
	
	

}
