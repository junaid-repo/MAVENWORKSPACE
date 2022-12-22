package com.example.javapractise.thread2;

public class Thread1 implements Runnable  {

	public static void main(String[] args) {
		Thread1 td1 = new Thread1();
		Runnable rn = new Thread(td1);
		//Thread t1 = new Thread(td1);
		((Thread) rn).start();
	}

	@Override
	public void run() {
		System.out.println("Inside the run method");
	}

}
