package com.example.javapractise.thread;

public class PrintingThread {

	public void printing() {
		for (int i = 0; i < 20; i++) {
			System.out.println("printing--> " + i);
		}
	}

	public void display() {
		for (int j = 100; j < 120; j++) {
			System.out.println("displaying--> " + j);
		}
	}

}
