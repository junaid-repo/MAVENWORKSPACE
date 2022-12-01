package com.example.javapractise.java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class JavaEightPractise8 {
	public static void main(String[] args) {

		List<Integer> l1 = List.of(3, 4, 15, 89, 44, 11, 112, 3331);
		
		Consumer<String> cs1=(s)->{
			System.out.println(s);
		};

		l1.stream().map(i -> i + "").filter(i -> i.startsWith("1")).forEach(cs1);
		
	
		
		System.out.println(l1.stream().count());
		
		Function<Integer,String> fn1=(a)->{
			
			return a.toString();
		};
		l1.stream().map(fn1).map(i -> i.charAt(0)).forEach(System.out::println);

	}
}