package com.example.javapractise.java8;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaEightPractise3 {
	public static void main(String[] args) {

		List<Integer> list1 = List.of(42, 98, 67, 283, 902, 77);
		// System.out.println(list1);

		//Predicate<Integer> evenPredicate = i -> i % 2 == 0;
		//Predicate<Integer> oddPredicate = i -> i % 2 == 1;

		filterAndPrint(list1, i -> i % 2 == 0);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		filterAndPrint(list1, i -> i % 2 == 1);

	}

	private static void filterAndPrint(List<Integer> list1, Predicate<Integer> predicate) {
		list1.stream().filter(predicate).forEach(System.out::println);
	}

}
