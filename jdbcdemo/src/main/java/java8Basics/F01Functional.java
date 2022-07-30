package java8Basics;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class F01Functional {

	public static void main(String[] args) {
		printCubesOfEvenNumber(List.of(43, 53, 98, 12, 30, 64));
	}

	private static void printCubesOfEvenNumber(List<Integer> numbers) {

		Predicate<Integer> checkEven = i -> i % 2 == 0;

		Predicate<Integer> checkEven2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {

				return x % 2 == 1;
			}
		};

		Function<Integer, Integer> makeCubes = j -> j * j * j;
		Consumer<Integer> printIt = k -> System.out.println(k);
		numbers.stream().filter(checkEven2).map(makeCubes).forEach(printIt);
	}

}
