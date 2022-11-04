package com.example.javapractise.java8;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class JavaEightPractise2 {
	public static void main(String[] args) {

		List<Integer> list1 = List.of(42, 98, 67, 283, 902, 77);
		System.out.println(list1);

		BinaryOperator<Integer> getSum = (x, y) -> x +y;
		
		BinaryOperator<Integer> getSum2 = new BinaryOperator<Integer>(){

			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}
			
		};

		
		
		
		System.out.println(list1.stream().reduce(0, getSum2));

	}

}
