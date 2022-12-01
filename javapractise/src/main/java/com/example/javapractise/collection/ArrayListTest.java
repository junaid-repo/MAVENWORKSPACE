package com.example.javapractise.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Double> ar = new ArrayList<>();
		List<Double> ll = new LinkedList<>();

		for (double a = 54745; a < 54795; a++) {
			ar.add(a);
		}
		// System.out.println(ar);
		// System.out.println(ar.indexOf(11));
		// System.out.println(ar.get(4));

		Iterator it = ar.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		for (double a = 244; a < 300; a++) {
			ll.add(a);
		}

		Iterator l2=ll.iterator();
		while(l2.hasNext())
			System.out.println(l2.next());
	}

}
