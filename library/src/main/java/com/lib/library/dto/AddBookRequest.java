package com.lib.library.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddBookRequest {

	List<Map> bookDetails = new ArrayList<>();

	public List<Map> getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(List<Map> bookDetails) {
		this.bookDetails = bookDetails;
	}

	@Override
	public String toString() {
		return "AddBookRequest [bookDetails=" + bookDetails + "]";
	}

}
