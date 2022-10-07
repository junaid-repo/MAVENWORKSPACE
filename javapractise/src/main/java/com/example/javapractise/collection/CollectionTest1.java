package com.example.javapractise.collection;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest1 {

	public static void main(String[] args) {
		List<String> ar = new ArrayList<>();
		List<String> ar2 = new ArrayList<>();

		ar.add(0, "pl");
		ar.add(1, "cc");
		ar.add(2, "tst");
		ar.add(3, "dd");

		ar2.add(0, "vf");
		ar2.add(1, "wet");
		ar2.add(2, "bs");
		ar2.add(3, "qq");
		ar2.addAll(ar);
		System.out.println(ar2);
	}

}
