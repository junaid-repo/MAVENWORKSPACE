package java8Basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Practise1 {
	@Autowired
	TestI obj;

	public static void main(String[] args) {
		int ar[] = { 45, 77, 41, 89, 44, 91, 62, 9 };
		Practise1 pc = new Practise1();

		System.out.println(pc.printOddNumber(ar));

	}

	int printOddNumber(int arg[]) {
		int value = 0;
		
		value = obj.multipleOfOddNumber(arg);

		return value;

	}

}
