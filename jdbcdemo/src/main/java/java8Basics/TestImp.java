package java8Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class TestImp implements TestI {

	@Override
	public int multipleOfOddNumber(int[] number) {

		List<Integer> numb = new ArrayList<>();

		for (int j = 0; j < number.length; j++) {
			numb.add(number[j]);
		}

		Integer value = 0;
		value = numb.stream().filter(i -> i % 2 == 1).reduce(0, Integer::sum);
		
		return value;
	}

}
