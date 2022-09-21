package java8Basics;

public class Area {

	private int length;
	private int breadth;

	public Area(int length, int breadth) {

		this.length = length;
		this.breadth = breadth;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getBreadth() {
		return breadth;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	@Override
	public String toString() {
		return "Area [length=" + length + ", breadth=" + breadth + ", getLength()=" + getLength() + ", getBreadth()="
				+ getBreadth() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
