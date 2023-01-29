package com.shop.inventories;

public class JavaThread implements Runnable {
	public static void main(String[] args) {

		Runnable rn = new Runnable() {
			@Override
			public void run() {
				System.out.println("Inside the run method");
			}
		};

		JavaThread jt = new JavaThread();
		Thread td = new Thread(jt);
		Thread td2= new Thread(rn);
		td2.start();
		td.start();

	}

	@Override
	public void run() {
		System.out.println("Inside the outside run method");

	}
}