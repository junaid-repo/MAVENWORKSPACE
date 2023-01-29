package com.shop.locations;

import java.util.ArrayList;
import java.util.List;

public class InterTest {

	public static void main(String[] args) {
		List<Integer> numList = List.of(43, 55, 0, 98, 0, 87, 2, 0);

		List<Integer> finList = new ArrayList<>();

		int size = numList.size();
		int temp = 0;

		for (Integer tempNum : numList) {

			temp++;
			if (tempNum != 0) {
				finList.add(tempNum);
			} else {
				finList.add(0);
				finList.add(0);
			}
			int size2 = finList.size();
			if (size == size2)
				break;
		}

		System.out.println(finList);
	}

}
