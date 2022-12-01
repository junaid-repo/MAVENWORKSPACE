package com.example.javapractise.java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JavaEightPractise4 {
	public static void main(String[] args) {

		List<Integer> marks = List.of(34, 52, 98, 13, 55, 25, 98, 44, 24, 95, 76, 44, 50);
		List<Integer> marks2 = List.of(1, 2, 3, 4, 11, 12, 14, 16, 24, 25, 67, 88, 92);

		Integer sum = marks.stream().filter(i -> i > 50).reduce(0, (n, m) -> (n + m));
		System.out.println(sum);

		Consumer<Integer> method2 = (a) -> {
			System.out.println(a);
		};

		Predicate<Integer> m3 = (i) -> {

			return false;
		};

		marks2.stream().forEach(method2);

		System.out.println(marks2.stream().filter(m3).count());

		Supplier<Integer> m4 = () -> {
			return 445;
		};
		m4.get();

		Function<Integer, Integer> m5 = (a) -> {

			return (a);

		};

		marks.stream().map(m5).forEach(System.out::println);
		;

	}

}
