package com.example.javapractise.string;

public class StringDeclarations {
	public static void main(String[] args) {
		String s = "Here is the new String";
		System.out.println(s);
		String s2 = new String("Here it is created with object");
		System.out.println(s2);
		char ar[] = { 'a', 'b', 'c', 'd', 'e' };
		String s3 = new String(ar);
		System.out.println(s3);
		
		String st1="Hello";
		String st2=st1.concat(" World");
		String st3="My";
		System.out.println(st3);
		 st3="Name";
		 System.out.println(st3);

		System.out.println(st2);

	}
}
