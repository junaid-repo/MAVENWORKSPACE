package com.jdbcdemo.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CountriesDetailsResponse {
	
	List<Map> detailsList = new ArrayList<>();

	public List<Map> getDetailsList() {
		return detailsList;
	}

	public void setDetailsList(List<Map> detailsList) {
		this.detailsList = detailsList;
	}

	@Override
	public String toString() {
		return "CountriesDetailsResponse [detailsList=" + detailsList + ", getDetailsList()=" + getDetailsList() + "]";
	}
	
	
	

}
