package com.shop.products;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApi {
	


	public static void main(String[] args) {
		List list1 = List.of("Junaid", "Khan", "is", "the", "best");

		//System.out.println(list1.stream().findFirst());
		
	//	System.out.println(list1.stream().skip(list1.size()-2).findFirst());
		
		List list2=List.of("12", "33", "12", "43", "33", "87", "33");
		Set<String> items= new HashSet<>();
		
		Object list3=new ArrayList<>();
		list3=	list2.stream().filter(n->!items.add((String) n)).collect(Collectors.toList());
		
		//System.out.println(list3);
		
		 double a = 295.04;
	     int  b = 300;
	     byte c = (byte) a;
	     byte d = (byte) b;
	     System.out.println(c + " "  + d);
	     
		//System.out.println("Aaaabbccdsde".chars().filter(i->i=='a').count());
		
	     int sum = 0;
         for (int i = 0, j = 0; i < 10 & j < 10; ++i, j = i + 1)
             sum += i;
      System.out.println(sum);
	}

}
