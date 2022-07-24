package com.jdbcdemo.jdbcdemo.javaTest;

import java.util.ArrayList;

public class TestFI {

	public static void main(String[] args) {
		TestItFnInt obj = new TestItFnInt();
		
		ArrayList<String> ar = new ArrayList<>();
		ar.add("aa");
		ar.add("bb");
		ar.add("cc");
		
		
		System.out.println(obj.mainIt(ar));
	}

}
