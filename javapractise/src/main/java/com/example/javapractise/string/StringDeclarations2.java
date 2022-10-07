package com.example.javapractise.string;

import java.util.LinkedList;
import java.util.List;

public class StringDeclarations2 {
	public static void main(String[] args) {
		
		String s1="Cricket";
		String s2="Cricket";
		String s3="cricket";
		String s4 = new String("Cricket");
		String s5 = new String("Cricket");
		
		List<String> ll= new LinkedList<>();
		ll.add("this is it");
		System.out.println(ll.get(0));
		
		System.out.println(s1.equals(s2)); //true
		System.out.println(s2.equalsIgnoreCase(s3));//true
		System.out.println(s3.equalsIgnoreCase(s4));//true
		System.out.println(s2==s4);//false
		System.out.println(s4==s5);//false
				
		
	}
}
