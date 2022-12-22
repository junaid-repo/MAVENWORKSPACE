package com.lib.library.service.interfaces.functional;

import java.util.List;
import java.util.Map;

import com.lib.library.dto.AddBookRequest;

@FunctionalInterface
public interface AddBookInterface {

	List addABook(AddBookRequest request);

	default void addABook2(Map request) {
		System.out.println("Inside the AddBookInterface ");
	}

}
