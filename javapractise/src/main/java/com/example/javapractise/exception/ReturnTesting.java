package com.example.javapractise.exception;

public class ReturnTesting {

	int m1() {
		try {
			System.out.println("I am in try block");
			return 50;
		} catch (Exception e) {
			System.out.println("I am in catch block");
			return 30;
		}
	}

	public static void main(String[] args) {
		ReturnTesting obj = new ReturnTesting();
		System.out.println(obj.m1());
	}
}
