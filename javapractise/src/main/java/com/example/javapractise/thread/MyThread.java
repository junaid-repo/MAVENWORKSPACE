package com.example.javapractise.thread;

public class MyThread extends Thread {

	String st1 = "";

	MyThread(String st) {
		st1 = st;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(2000);
				System.out.println(st1 + " " + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		MyThread td1 = new MyThread("Open your system");
		MyThread td2 = new MyThread("install windows");

		Thread t1 = new Thread(td1);
		Thread t2 = new Thread(td2);
		t1.start();
		t1.setPriority(MAX_PRIORITY);
		t2.start();
	}

}