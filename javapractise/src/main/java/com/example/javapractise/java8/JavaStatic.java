package com.example.javapractise.java8;

public class JavaStatic {
	
	static int a=8;
	
	JavaStatic(){
		a++;
	}
	
	void display() {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		JavaStatic js1= new JavaStatic();
		js1.display();
		JavaStatic js2= new JavaStatic();
		js2.display();
		JavaStatic js3= new JavaStatic();
		js3.display();
		JavaStatic js4= new JavaStatic();
		js4.display();
	}

}
