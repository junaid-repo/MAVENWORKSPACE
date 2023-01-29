package com.shop.inventories;

public class JavaPrac1 extends Thread implements Runnable {
	public static void main(String[] args) throws InterruptedException {

		int a = 12;
		Runnable rn = new Runnable() {
			@Override
			public void run() {
				checkTheSync();
				/*
				 * for (int i = 0; i < 100; i++) { System.out.println("@@@@-->" + i); }
				 */

				System.out.println("Inside the run mehtod of runnnable block");
			}
		};

		Thread td = new Thread(rn);
		td.start();
		td.setPriority(10);
//	td.join();

		JavaPrac1 jp = new JavaPrac1();
		jp.start();

	}

	public void run() {
		checkTheSync();
		/*
		 * for (int i = 1111; i < 1200; i++) { System.out.println("$$$$$-->" + i); }
		 */
		System.out.println("Inside the outside run method");
	}

	public static void checkTheSync() {
		for (int i = 0; i < 10; i++) {
			System.out.println("&&&&&&&&&&&&&-->" + i);

		}
	}

}