package com.example.javapractise.java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class JavaEightPractise8 {
	public static void main(String[] args) throws NameNotFoundException {

		String st = "aa";
		if (st != "ab") {
			throw new NameNotFoundException("The name is not found");
		}
		String s1 = new String("Junaid");
		String s2 = new String("Junaid");
		System.out.println(s1 == s2);
	}

}