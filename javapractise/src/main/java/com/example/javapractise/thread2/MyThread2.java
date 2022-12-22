package com.example.javapractise.thread2;

public class MyThread2{
	
	public static void main(String[] args) {
		System.out.println("This is inside the main method");
		MyThread2 obj =new MyThread2();
		
		
		
	}
	
	public class T2 extends Thread{
		
	public	void run() {
			System.out.println("Inside the run method"); 	
		}
	

}
}