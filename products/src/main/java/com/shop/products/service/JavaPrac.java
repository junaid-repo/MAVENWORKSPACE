package com.shop.products.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaPrac {

	public static void main(String[] args) {
		List<String> l1 = List.of("Joey", "Chanlder", "Monica", "Ross", "Rachael", "Phoebe");
		List<Integer> intList = List.of(43, 55, 98, 42, 12, 76, 33, 98);
		Set<Integer> set = new HashSet<>();
		List<Employee> empList = List.of(new Employee("Ram", 35, 40000.00F), new Employee("Charan", 41, 74500.00F),
				new Employee("Teja", 27, 52110.00F));

		empList.stream().filter(i -> i.getSalary() > 40000.00F).forEach(System.out::println);

	}

}
