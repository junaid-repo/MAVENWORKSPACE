package java8Basics;

public class AreaTest {

	public static void main(String[] args) {
		Area ob = new Area(45, 30);
		System.out.println("Pre defined Area " + ob.getBreadth() * ob.getLength());

		ob.setBreadth(90);
		ob.setLength(60);
		System.out.println("New Area " + ob.getBreadth() * ob.getLength());

	}

}
