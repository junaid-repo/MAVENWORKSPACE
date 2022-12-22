package com.lib.library.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;

public class AddBookResponse extends BaseOutput {

	private List<Map> addedBookDetails = new ArrayList<>();

	public List<Map> getAddedBookDetails() {
		return addedBookDetails;
	}

	public void setAddedBookDetails(List<Map> addedBookDetails) {
		this.addedBookDetails = addedBookDetails;
	}

	@Override
	public String toString() {
		return "AddBookResponse [addedBookDetails=" + addedBookDetails + "]";
	}

	
}
