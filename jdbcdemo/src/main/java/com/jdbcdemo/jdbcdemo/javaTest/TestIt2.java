package com.jdbcdemo.jdbcdemo.javaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestIt2 {

	public static void main(String[] args) {
	
		List<Integer> ar = new ArrayList<>();

		for (int i = 0; i < 100; i = i + 5) {
			ar.add(i);
		}

		// ar.stream().forEach(System.out::println);

		Predicate<Integer> predicate = i -> i % 3 == 0;
		Predicate<Integer> predicate2 = i -> i % 2 == 1;
		
		extracted(ar, predicate2);
		
		
		

	}

	private static void extracted(List<Integer> ar, Predicate<Integer> predicate) {
		System.out.println(ar.stream().filter(predicate).collect(Collectors.toList()));
	}

}
