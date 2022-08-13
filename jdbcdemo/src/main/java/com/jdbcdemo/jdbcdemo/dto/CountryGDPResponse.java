package com.jdbcdemo.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.List;

public class CountryGDPResponse extends BaseOutput{
	
	List<CountryGDPList> countryGDPList =  new ArrayList<>();

	


	public List<CountryGDPList> getCountryGDPList() {
		return countryGDPList;
	}

	public void setCountryGDPList(List<CountryGDPList> countryGDPList) {
		this.countryGDPList = countryGDPList;
	}

	@Override
	public String toString() {
		return "CountryGDPResponse [countryGDPList=" + countryGDPList + ", getCountryGDPList()=" + getCountryGDPList()
				+ ", getErrorCode()=" + getErrorCode() + ", getErrorDesc()=" + getErrorDesc() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	

}
