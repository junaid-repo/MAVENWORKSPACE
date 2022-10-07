package com.example.javapractise.oopsconcetps.inheritance;

public class OverloadChildChildClass extends OverloadChildClass{
	
	void display(int x) {
		System.out.println("Insdie OverloadChildChildClass with  value  "+x);
	}
	

	void display() {
		System.out.println("Insdie OverloadChildChildClass with no  value  ");
	}
	void display(String s) {
		System.out.println("Insdie OverloadChildChildClass with values  "+s);
	}
	
}
