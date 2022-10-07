package com.example.javapractise.oopsconcetps.abstraction;

public abstract class AbstractWithAllTypeOfDataTypes {

	static int a = 20;
	int b = 33;

	public AbstractWithAllTypeOfDataTypes(int b) {
		super();
		this.b = b;
		System.out.println("Inside the constructor of AbstractWithAllTypeOfDataTypes with values " + b);
	}
	
	abstract void display();

	void display(int k) {
		System.out.println(k);
		final int b = 20;
		System.out.println(b);

	}

	public static void display2() {
		System.out.println(a);

	}

}
