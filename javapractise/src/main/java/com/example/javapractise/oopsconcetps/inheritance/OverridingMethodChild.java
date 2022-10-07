package com.example.javapractise.oopsconcetps.inheritance;

public class OverridingMethodChild extends OverridingMethodParent {
	
	/*
	 * { show(); }
	 */
	
	public OverridingMethodChild() {
		System.out.println("Constructor OverridingMethodChild");
	}
	
	void show() {
		System.out.println("Inside show method of OverridingMethodChild");
	}

}
