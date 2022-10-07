package com.example.javapractise.oopsconcetps.abstraction;

public class AbstractTest1 {

	public static void main(String[] args) {
		AbsSum sum = new AbsSum();
		AbsMultiply mul = new AbsMultiply();
		AbsDivide div = new AbsDivide();

		int a = 48;
		int b = 12;
		sum.calculate(a, b);
		mul.calculate(a, b);
		div.calculate(a, b);

	}

}
