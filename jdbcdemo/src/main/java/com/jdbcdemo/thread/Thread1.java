package com.jdbcdemo.thread;

public class Thread1{
	public static void main(String[] args) {
		System.out.println("Starting to learn thread");
		
		Thread td = new Thread() {
			
			@Override
			public void run() {
				System.out.println("Inside the run method  "+Thread.currentThread().getName());
			}
			
			
		};
			td.start();
		
	}
	
}