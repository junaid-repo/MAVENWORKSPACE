package com.example.javapractise.oopsconcetps.abstraction;

public class InterfaceTest1 {
	
	public static void main(String[] args) {
		ClassB ob = new ClassB();
		ob.msg();
		ob.show();
		
		InterfaceA inf= new ClassB();
		inf.msg();
	}

}
