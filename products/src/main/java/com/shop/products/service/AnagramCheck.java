package com.shop.products.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AnagramCheck {

	public static void main(String[] args) {
		List aa= List.of("aa", "dd", "ee");
		
		System.out.println(aa);
		
		aa.stream().sorted().forEach(System.out::println);
		
	}

}
