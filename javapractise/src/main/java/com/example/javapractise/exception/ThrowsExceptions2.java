package com.example.javapractise.exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ThrowsExceptions2 {
	String a = "";
	String b = "";

	public static void main(String[] args) throws IOException {

		ThrowsExceptions2 ob = new ThrowsExceptions2();
		ob.receive();
		ob.display();

	}

	public void receive() throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the values");
		a=sc.next();
		b=sc.next();
		

	}

	public void display() {
		System.out.println(a);
		System.out.println(b);
	}

}
