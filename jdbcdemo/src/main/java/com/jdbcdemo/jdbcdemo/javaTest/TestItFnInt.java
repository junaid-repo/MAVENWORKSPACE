package com.jdbcdemo.jdbcdemo.javaTest;

import java.util.ArrayList;

import com.jdbcdemo.jdbcdemo.javaTest.FuncInterface;

class TestItFnInt {
	public  String mainIt(ArrayList<String> ar) {

		

		FuncInterface fobj = (ArrayList<String> st) -> {
			String a="";
			for (String j : st) {
				a = a + " " + j;
			}return a;
			
		};

		// This calls above lambda expression and prints 10.
		return fobj.abstractFun(ar); 
	}
}