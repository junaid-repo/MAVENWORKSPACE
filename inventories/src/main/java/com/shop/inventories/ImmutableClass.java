package com.shop.inventories;

import java.util.Iterator;
import java.util.List;

public final class ImmutableClass {
	public static void main(String[] args) {
		String name = "Junaid";
		Integer age = 27;
		List<Integer> numList = List.of(34, 55, 83, 11, 40, 12, 9);

		Iterator<Integer> itr = numList.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
