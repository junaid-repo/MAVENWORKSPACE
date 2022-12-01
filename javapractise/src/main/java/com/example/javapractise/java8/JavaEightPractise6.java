package com.example.javapractise.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.jdbcdemo.jdbcdemo.dto.EmployeeDetails;

public class JavaEightPractise6 {
	public static void main(String[] args) {

		List<EmployeeDetails> empDetailsList = new ArrayList<>();
		EmployeeDetails obj = new EmployeeDetails();
		obj.setName("");
		obj.setEmpId("1111");
		obj.setSalary(50000);

		EmployeeDetails obj2 = new EmployeeDetails();
		obj2.setName("King");
		obj2.setEmpId("2243");
		obj2.setSalary(20000);

		EmployeeDetails obj3 = new EmployeeDetails();
		obj3.setName("Khan");
		obj3.setEmpId("2241");
		obj3.setSalary(60000);

		empDetailsList.add(obj);
		empDetailsList.add(obj2);
		empDetailsList.add(obj3);

		System.out.println(empDetailsList.stream().map(i -> i.getSalary()).reduce(0l,(a,b)->a+b));
	}

}