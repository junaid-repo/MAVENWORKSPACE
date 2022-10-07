package com.example.javapractise.exception;

public class ExceptionHandling3 {

	public static void main(String[] args) {
		ExceptionHandling3 obj = new ExceptionHandling3();
		System.out.println(obj.m1());
	}

	int m1() {

		int a = 0;
		int b = 90;
		int c;
		try {
			System.out.println("Inside try block of m1 ");
			c = b / a;
			return 30;
		} catch (Exception e) {
			System.out.println("Inside catch block of m1 ");
			return 30;

		} finally {
			System.out.println("Inside finally block of m1 ");
			return 80;

		}
	}

}
