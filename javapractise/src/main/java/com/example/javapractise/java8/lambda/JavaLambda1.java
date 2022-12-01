package com.example.javapractise.java8.lambda;

public class JavaLambda1 {
	public static void main(String[] args) {

		Runnable runn = new Runnable() {

			@Override
			public void run() {
				System.out.println("Inside the runnable");
			}

		};

		new Thread(runn).start();

	}

}
