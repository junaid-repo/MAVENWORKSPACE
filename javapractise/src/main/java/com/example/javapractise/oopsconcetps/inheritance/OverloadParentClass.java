package com.example.javapractise.oopsconcetps.inheritance;

public class OverloadParentClass {
	
	void display() {
		System.out.println("Insdie OverloadParentClass with no values");
	}void display(String s) {
		System.out.println("Insdie OverloadParentClass with values  "+s);
	}void display(String s, String y) {
		System.out.println(y+" Insdie OverloadParentClass with values  "+s);
	}
}	
