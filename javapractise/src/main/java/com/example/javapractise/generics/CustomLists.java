package com.example.javapractise.generics;

import java.util.ArrayList;

public class CustomLists<T> {
	
	ArrayList<T> l1= new ArrayList<>();
	
	ArrayList<T> l2= new ArrayList<>();
	
	public void addElement(T element) {
		l1.add(element);
	}
	
	public void removeElement(String element) {
		l1.remove(element);
	}
	@Override
	public String toString() {
		return "CustomLists [l1=" + l1 + "]";
	}
}
