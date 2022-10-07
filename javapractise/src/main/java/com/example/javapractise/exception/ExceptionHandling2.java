package com.example.javapractise.exception;

public class ExceptionHandling2 {

	public static void main(String[] args) {

		int a = 1;
		int b = 9;
		int c = 0;
		System.out.println("starts here");
		// System.exit(0);
		try {

			c = b / a;
			System.exit(0);

		}

		catch (ArithmeticException e) {
			System.out.println("Divide by zero error");
		}

		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Divide by zero error");
		} finally {
			// c = b / a;
			System.out.println("Finally it is here");
			System.out.println("Finally it is here successfully");
		}
		System.out.println("ends here");

		/*
		 * try { System.out.println("111"); System.out.println(20/0);
		 * System.out.println("222"); } catch(ArithmeticException ae) {
		 * System.out.println("333"); } finally { System.out.println(10/0); // Exception
		 * occurred in finally block. } System.out.println("555");
		 */

	}

}
