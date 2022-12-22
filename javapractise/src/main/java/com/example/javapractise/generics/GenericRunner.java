package com.example.javapractise.generics;

public class GenericRunner {

	public static void main(String[] args) {
		CustomLists<String> l1 = new CustomLists();
		l1.addElement("aa");
		l1.addElement("bb");
		l1.addElement("cc");
		System.out.println(l1.toString());
		CustomLists<Integer> l2 = new CustomLists();

		l2.addElement(23);
		l2.addElement(23);
		l2.addElement(55);

		System.out.println(l2.toString());
	}
}
