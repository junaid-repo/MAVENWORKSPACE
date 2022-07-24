package com.jdbcdemo.jdbcdemo.dto;

public class InsertEmployeeList {
	
	private String firstName="";
	private String lastName="";
	private String email="";
	private String phoneNumber="";
	private String hireDate="";
	private String jobId="";
	private int salary=0;
	private int commisionPct=0;
	private int managerId=0;
	private int departmentId=0;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getCommisionPct() {
		return commisionPct;
	}
	public void setCommisionPct(int commisionPct) {
		this.commisionPct = commisionPct;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "InsertEmployeeList [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary
				+ ", commisionPct=" + commisionPct + ", managerId=" + managerId + ", departmentId=" + departmentId
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getEmail()="
				+ getEmail() + ", getPhoneNumber()=" + getPhoneNumber() + ", getHireDate()=" + getHireDate()
				+ ", getJobId()=" + getJobId() + ", getSalary()=" + getSalary() + ", getCommisionPct()="
				+ getCommisionPct() + ", getManagerId()=" + getManagerId() + ", getDepartmentId()=" + getDepartmentId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
