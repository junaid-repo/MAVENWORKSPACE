package java8Basics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class F01Structured {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>();
		arr.add(21);
		arr.add(4);
		arr.add(55);
		arr.add(45);
		arr.add(18);
		Integer minSum = 0;
		Integer maxSum = 0;
		Integer min = arr.get(0);
		Integer max = arr.get(0);

		for (Integer i : arr) {
			if (i < min)
				min = i;
			if (i > max)
				max = i;

		}
		for (Integer i : arr) {
			if (i != max)
				minSum = minSum + i;
			if (i != min)
				maxSum = maxSum + i;
		}

		/*
		 * System.out.println(min); System.out.println(max); System.out.println(minSum);
		 * System.out.println(maxSum);
		 */
		String a = "9875";

		System.out.println(superDigit(a, 4));

	}

	public static int superDigit(String n, int k) {
		String conCat = n;

		conCat = n.repeat(k);
		//Integer num = Integer.valueOf(conCat).intValue();

		System.out.println(conCat);

		return superDigit(conCat);

	}

	public static int superDigit(String conCat) {

		Integer num = Integer.parseInt(conCat);
		Integer toPass = 0;
		Integer count = 0;
		while (num > 0) {
			toPass = toPass + (num % 10);
			count++;
			num = num / 10;
		}
		if (toPass > 10) {
			return superDigit(toPass.toString(), count);
		} else
			return toPass;

		// return toPass;
	}
}
