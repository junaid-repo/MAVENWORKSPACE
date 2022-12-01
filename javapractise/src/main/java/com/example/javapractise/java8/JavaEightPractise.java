package com.example.javapractise.java8;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class JavaEightPractise {
	public static void main(String[] args) {

		List<Integer> list1 = List.of(43, 54, 194, 51, 35, 63);
		List<Integer> list2 = List.of(2, 3, 4, 5);
		List<Integer> list3 = List.of(2, 3, 4, 5, 3, 5, 2, 90, 3, 66, 3);

		Predicate<Integer> pred1 = i -> i % 2 == 0;
		Predicate<Integer> pred2 = i -> i % 2 == 1;
		extracted1(list1, pred1);
		extracted1(list1, pred2);

		 System.out.println(list1.stream().reduce(0, (x,y)->x+y));
		System.out.println(list3.stream().filter(i -> i % 2 == 0).map(x -> x / 3).reduce(0, (x, y) -> x + y));

		BiConsumer<Integer, Integer> biCon = (x, y) -> System.out.println(x + y);

		biCon.accept(44, 99);

		BiPredicate<Integer, Integer> biPred = (num1, num2) -> {

			if (num1 > 20 && num2 < 222)
				return true;
			else
				return false;
		};

		System.out.println(biPred.test(243, 998));

		Comparator<Integer> comparing1 = Comparator.comparing(num -> num > 50);
		Comparator<Integer> comparing2 = Comparator.comparing(num -> num > 20);

		extracted1(list3, comparing2);

		Function<Integer, Integer> mapper1 = x -> x + 9;
		extracted1(list2, mapper1);

	}

	private static void extracted1(List<Integer> list2, Function<Integer, Integer> mapper1) {
		Consumer< Integer> output = System.out::println;
		list2.stream().map(mapper1).forEach(output);
	}

	private static void extracted1(List<Integer> list3, Comparator<Integer> comparing1) {
		list3.stream().sorted(comparing1).distinct().forEach(System.out::println);
	}

	private static void extracted1(List<Integer> list1, Predicate<Integer> pred1) {
		System.out.println("################################");
		list1.stream().filter(pred1).forEach(System.out::println);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}

}
