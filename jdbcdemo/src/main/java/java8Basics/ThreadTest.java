package java8Basics;

public class ThreadTest extends Thread {
	public String text = "This needs to be printed";

	public static void main(String[] args) {
		ThreadTest ob = new ThreadTest();
		ThreadClass1 obj = new ThreadClass1(ob);
		Thread rn = new Thread(obj);
		rn.start();

	}

}
