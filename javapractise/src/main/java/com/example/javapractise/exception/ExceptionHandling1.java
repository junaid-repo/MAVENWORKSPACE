package com.example.javapractise.exception;

public class ExceptionHandling1 {

	public static void main(String[] args) {
		int a = m1();
		System.out.println(a);
	}

	public static int m1() {
		int b = 0;
		try {
			b = m2();
		} finally {
			// TODO Auto-generated catch block
			System.out.println("Here is the finally block");
		}

		return b;
	}

	public static int m2() {
		int c = 0;
		try {
			c = m3();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	public static int m3() {
		int d = 0;
		d = 3 / 0;

		return d;
	}
}
