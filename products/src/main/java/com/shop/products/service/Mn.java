package com.shop.products.service;

public class Mn {
	String st = "eeeeee";

	public void checkString(String str) throws MyCusException {
		if (st != str) {
			throw new MyCusException("The excpetion caught");
		}
	}

	public static void main(String[] args) throws MyCusException {
		Mn ob = new Mn();

		ob.checkString("ddd");

		System.out.println("another catch");

	}
}
