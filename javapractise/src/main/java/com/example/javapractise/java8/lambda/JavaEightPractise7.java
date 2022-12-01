package com.example.javapractise.java8.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class JavaEightPractise7 {
	public static void main(String[] args) {

		List<String> st1 = List.of("Junaid", "King", "Khan", "Junaid", "Raja", "Khan");

		// System.out.println(st1.stream().map(i -> i).findFirst());

		System.out.println(st1.stream().reduce((a, b) -> b));

		// st1.stream().filter(i->i.compareTo(i+1));

		int count = 0;

		Predicate<String> fl1 = (s1) -> {

			if (s1.contains("aj"))
				return true;
			return false;
		};

		st1.stream().filter(fl1).forEach(System.out::println);
		st1.stream().filter(fl1).forEach(System.out::println);

		Function<String, Integer> fn1 = (s2) -> {
			Integer a = 0;
			if (s2.contains("aid")) {
				a++;
			}
			return a;
		};
		Function<String, String> fn2 = (s2) -> {
			String st2 = "";

			for (int i = s2.length() - 1; i > -1; i--) {
				//System.out.println();
				st2 = st2 + s2.charAt(i);
			}

			return st2;
		};
		System.out.println(st1.stream().map(fn1).reduce(0, (a, b) -> a + b));
		Consumer<? super String> action = System.out::print;
		st1.stream().map(fn2).forEach(action);

	}

}