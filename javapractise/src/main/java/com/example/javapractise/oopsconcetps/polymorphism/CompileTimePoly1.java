package com.example.javapractise.oopsconcetps.polymorphism;

public class CompileTimePoly1 {

	public void sum(int a, int b) {
		System.out.println("The sum inside CompileTimePoly2 =" + (a + b));
	}

	public void sum(int a, int b, int c) {
		System.out.println("The sum inside CompileTimePoly2 =" + (a * b * c));
	}
}
