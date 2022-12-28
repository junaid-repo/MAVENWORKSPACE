package com.example.javapractise.collection;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MyMathTest {
	
	@Test
	void test() {
		List<Integer> myNumber= List.of(4,53,66);
		Integer output=0;
		MyMath obj = new MyMath();
		output=obj.findSum(myNumber);
		System.out.println(output);
		
	}

}
