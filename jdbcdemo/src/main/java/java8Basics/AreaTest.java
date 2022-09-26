package java8Basics;

public class AreaTest {

	public static void main(String[] args) {
		Area ob = new Area();
		//System.out.println("Pre defined Area " + ob.getBreadth() * ob.getLength());

		ob.setBreadth(90);
		ob.setLength(60);
		//System.out.println("New Area " + ob.getBreadth() * ob.getLength());
		//System.out.println();
		
		Area ar = new Circle();
		Circle are = new Circle();
		Area area = new Area();
		ar.display();
		are.display();
		area.display();
		
		Const1 con = new Const1(23, 44);
		con.display();
		
	}

}
