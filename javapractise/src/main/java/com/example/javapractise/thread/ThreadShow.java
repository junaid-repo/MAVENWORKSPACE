package com.example.javapractise.thread;

public class ThreadShow implements Runnable{
	public static void main(String[] args) {
		PrintingThread td = new PrintingThread();
	//	Thread th =  new Thread(td);
		td.printing();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
