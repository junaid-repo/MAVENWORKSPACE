package com.shop.products;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate currDate = LocalDate.now();
		System.out.println("Today--->" + currDate);
		LocalDate manualDate = LocalDate.of(2023, 11, 19);
		System.out.println(manualDate);

		String stDate = "2012-12-20";
		LocalDate stToDate = LocalDate.parse(stDate);
		System.out.println(stToDate);
		System.out.println("Yesterday--->" + currDate.minusDays(1));
		System.out.println("Tomorrow--->" + currDate.plusDays(1));
		System.out.println(currDate.isBefore(currDate.plusDays(1)));
		System.out.println(currDate.isAfter(currDate.minusDays(2)));
		System.out.println(currDate.isLeapYear());
		System.out.println(currDate.lengthOfMonth());
		System.out.println(currDate.lengthOfYear());

		LocalTime locTime = LocalTime.of(12, 33, 42);
		System.out.println(locTime);
		System.out.println(locTime.plusHours(15));
		System.out.println(locTime.getMinute());
		System.out.println(currDate.getDayOfWeek());

	}

}
