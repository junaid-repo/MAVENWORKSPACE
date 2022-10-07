package com.example.javapractise.oopsconcetps.inheritance;

public class OverloadChildClass extends OverloadParentClass{
	
	void display(int x) {
		System.out.println("Insdie OverloadChildClass with  value  "+x);
	}
	

	void display() {
		System.out.println("Insdie OverloadChildClass with no  value  ");
	}
	void display(String s) {
		System.out.println("Insdie OverloadChildClass with values  "+s);
	}
	
}
