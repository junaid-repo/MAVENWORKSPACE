package com.example.javapractise.thread;

public class Runnale implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		int a = 33;
		Runnable rn = new Runnable() {
			@Override
			public void run() {
				System.out.println(a);
				System.out.println("Inside the runnable");
			}
		};

		Thread td = new Thread(rn);
		td.sleep(1000);
	//	td.start();
		td.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
