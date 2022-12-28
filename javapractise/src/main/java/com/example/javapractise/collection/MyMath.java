package com.example.javapractise.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyMath {

	int findSum(List<Integer> numbers) {
		int sum=0;
		
		for(int num: numbers) {
			sum=sum+num;
		}
		
		return sum;
	}

}
