package java8Basics;

public class InterfaceTest {
	
	public static void main(String[] args) {
		ImplementsOuter out = new ImplementsOuter();
		out.display();
		ImplementsInner in = new ImplementsInner();
		in.display();
	}

}
