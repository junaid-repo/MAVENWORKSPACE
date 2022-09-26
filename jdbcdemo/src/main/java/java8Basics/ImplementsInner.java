package java8Basics;

public class ImplementsInner implements IOUTER.IInner{
	
	public void display() {
		System.out.println("inside the inner of outer interface");
	}

}
