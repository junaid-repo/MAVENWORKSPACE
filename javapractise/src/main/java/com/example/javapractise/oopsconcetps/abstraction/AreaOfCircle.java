package com.example.javapractise.oopsconcetps.abstraction;

public class AreaOfCircle implements InterfaceArea {

	public void calculate(int x, int y) {
		System.out.println("Area of circle="+(pi * x * x));
	}

}
