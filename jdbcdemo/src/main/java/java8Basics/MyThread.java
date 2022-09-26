package java8Basics;

public class MyThread extends Thread {
// Declare a String variable to represent task.
	String task;

	MyThread(String task) {
		this.task = task;
	}

	public void run() {
		for (int i = 1; i <= 5; i++) {
			System.out.println(task + " : " + i);
			try {
				Thread.sleep(1000); // Pause the thread execution for 1000 milliseconds.
			} catch (InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
		} // end of for loop.
	} // end of run() method.

	public static void main(String[] args) {
// Create two objects to represent two tasks.
		MyThread th1 = new MyThread("Cut the ticket"); // Passing task as an argument to its constructor.
		MyThread th2 = new MyThread("Show your seat number");

// Create two objects of Thread class and pass two objects as parameter to constructor of Thread class.
		Thread t1 = new Thread(th1);
		Thread t2 = new Thread(th2);
		t1.start();
		t2.start();
	}
}