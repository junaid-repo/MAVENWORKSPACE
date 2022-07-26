package java8Basics;

import java.util.List;

public class F01FunctionalPrograms {

	public static void main(String[] args) {
		printAllNumbers(List.of(32, 98, 45, 984, 234, 39));
	}

	private static boolean isEven(int i) {

		return (i % 2 == 0);
	}

	public static void printAllNumbers(List<Integer> L) {

		L.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
		L.stream().filter(F01FunctionalPrograms::isEven).forEach(System.out::println);

	}

}
