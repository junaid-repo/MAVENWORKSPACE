package com.shop.products;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi2 {

	public static void main(String[] args) {

		List<Integer> intList = List.of(23, 55, 12, 64, 98, 97, 23, 55);
		intList.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
		System.out.println("###########################################");
		intList.stream().map(i -> i.toString()).filter(i -> i.startsWith("1")).forEach(System.out::println);

		Set<Integer> intSet = new HashSet<>();
		System.out.println("###########################################");

		intList.stream().filter(i -> !intSet.add(i)).forEach(System.out::println);
		System.out.println("###########################################");

		System.out.println(intList.stream().findFirst());

		System.out.println("###########################################");

		System.out.println(intList.stream().map(i -> i).count());
		System.out.println("###########################################");

		System.out.println(intList.stream().max(Integer::compare).get());

		System.out.println("###########################################");

		System.out.println(intList.stream().sorted().skip(3).findFirst());
		System.out.println("###########################################");

		System.out.println(intList.stream().sorted().map(i -> i).collect(Collectors.toList()));
	}

}
