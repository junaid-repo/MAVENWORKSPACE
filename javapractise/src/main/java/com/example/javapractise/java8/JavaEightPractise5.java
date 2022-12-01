package com.example.javapractise.java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaEightPractise5 {
	public static void main(String[] args) {

		List<String> subjects = List.of("English", "Physics", "Chemistry", "Maths", "Computer Application",
				"Physical Education");
		List<Integer> marks2 = List.of(95, 67, 63, 65, 79, 80);

		Consumer<String> cs1 = (i) -> {
			System.out.println(i);
		};

		subjects.stream().forEach(cs1);

		Supplier<String> ss1 = () -> {
			return "OK";
		};

		System.out.println(ss1.get());

		Function<String, Integer> fn1 = (i) -> {
			return i.length();
		};

		subjects.stream().map(fn1).forEach(System.out::println);

		marks2.stream().reduce(0, (a, b) -> a + b);

		Predicate<String> pr1 = (i) -> {

			if (i.contains("s"))
				return true;
			return false;
		};

		subjects.stream().filter(pr1).count();

		System.out.println(marks2.stream().filter(i -> i > 60).mapToDouble(j -> j).average().getAsDouble());

		subjects.stream().map(i -> i.toUpperCase()).forEach(System.out::println);

		long c = marks2.stream().filter(i -> i > 60).map(i -> i).reduce(0, (a, b) -> a + b);
		long d = marks2.stream().filter(i -> i > 60).map(i -> i).count();

		System.out.println(c / d);

	}
}