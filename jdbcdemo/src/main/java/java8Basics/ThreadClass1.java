package java8Basics;

public class ThreadClass1 extends ThreadTest {
	ThreadTest ob = new ThreadTest();

	ThreadClass1(ThreadTest ob) {
		this.ob = ob;
	}

	
	public void run() {
		System.out.println(ob.text);
	}

}
