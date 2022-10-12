package com.example.javapractise.java8;

import java.util.List;
import java.util.stream.Collectors;

public class JavaEightPractise {
	public static void main(String[] args) {

		List<Integer> list1 = List.of(343, 5454, 10994, 551, 345, 643);

		//list1.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
		List<Integer> l2=list1.stream().filter(i->i%2==1).collect(Collectors.toList());
		//System.out.println(l2);
		
		//list1.stream().filter(i->i%2==1).map(x->x/2).forEach(System.out::println);
		System.out.println(list1.stream().filter(i->i%2==1).reduce(0, (x,y)->x+y+5000));
		list1.stream().filter(i->i%2==1).reduce(0, (x,y)->x+y+5000);


		
		IFN01 ob=(String st1)->{
			
			return st1.toUpperCase();
		};
		
		
		 //System.out.println(ob.changeCase("Junaid"));

	}
	
	
}
