package com.example.javapractise.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<>(33);
		for (int a = 0; a < 39; a++) {
			ar.add(a);
		}
		System.out.println(ar);
		System.out.println(ar.indexOf(11));
		System.out.println(ar.get(4));
	}

}
