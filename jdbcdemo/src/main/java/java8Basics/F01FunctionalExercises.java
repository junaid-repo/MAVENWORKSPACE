package java8Basics;

import java.util.List;

public class F01FunctionalExercises {

	public static void main(String[] args) {
		printAllNumbers(List.of(32, 98, 45, 984, 234, 39));
		printAllCourses(List.of("Spring Java", "WebLogic Server", "pse", "Oracle SQL", "Spring JSP"));
		printSquaresAllNumbers(List.of(32, 98, 45, 19, 234, 39));
	}

	public static void printAllNumbers(List<Integer> L) {

		L.stream().filter(i -> i % 2 == 1).forEach(System.out::println);
		System.out.println("############Printed all the numbers");

	}

	public static void printAllCourses(List<String> courses) {
		courses.stream().forEach(System.out::println);
		System.out.println("############Printed all the courses");
		courses.stream().filter(i -> i.contains("Spring")).forEach(System.out::println);
		System.out.println("############Printed all the couses with letter Spring");
		courses.stream().filter(i -> i.length() > 3).forEach(System.out::println);
		System.out.println("############Printed all the courses of size more than3");
		courses.stream().map(i->i.length()).forEach(System.out::println);
		System.out.println("############Printed length of all the courses");


	}

	public static void printSquaresAllNumbers(List<Integer> L) {

		L.stream().map(i -> i * i).forEach(System.out::println);
		System.out.println("############Printed squares of the number");

		L.stream().filter(i -> i % 2 == 1).map(i -> i * i * i).forEach(System.out::println);
		System.out.println("############Printed cubes of the odd numbers");

	}

}
