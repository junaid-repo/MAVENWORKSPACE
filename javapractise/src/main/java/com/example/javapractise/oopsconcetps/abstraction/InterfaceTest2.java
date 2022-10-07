package com.example.javapractise.oopsconcetps.abstraction;

public class InterfaceTest2 {
	public static void main(String[] args) {

		InterfaceArea area;

		area = new AreaOfCircle();
		area.calculate(12, 44);
		area = new AreaOfSquare();
		area.calculate(43, 85);
		area = new AreaOfRectangle();
		area.calculate(88, 74);
		
		SolveMathProblem solve = new SolveMathProblem();
		
		solve.calculate(43, 88);

	}
}
