package com.example.javapractise.oopsconcetps.abstraction;

public class SolveMathProblem implements InterfaceArea, InterfacePerimeter {

	@Override
	public void calculate(int x, int y) {
		System.out.println(2*(x + y));

	}

}
