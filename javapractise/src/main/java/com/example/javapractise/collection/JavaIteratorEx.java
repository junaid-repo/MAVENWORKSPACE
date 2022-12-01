package com.example.javapractise.collection;

import java.util.Iterator;
import java.util.List;

public class JavaIteratorEx {
	
	public static void main(String[] args) {
		List<String> st1=List.of("Junaid","Raza", "King", "Khan");
		
		Iterator it= st1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
