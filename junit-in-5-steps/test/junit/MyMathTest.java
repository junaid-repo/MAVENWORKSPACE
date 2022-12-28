package junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;



class MyMathTest {
	@Test
	void test() {
		Integer expectedOutput=123;
		List<Integer> myNumber= List.of(4,53,66);
		Integer output=0;
		MyMath obj = new MyMath();
		output=obj.findSum(myNumber);
		System.out.println(output);
		assertEquals(expectedOutput, output);
	}
}
