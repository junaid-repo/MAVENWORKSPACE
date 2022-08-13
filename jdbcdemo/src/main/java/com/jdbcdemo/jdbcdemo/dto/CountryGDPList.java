package com.jdbcdemo.jdbcdemo.dto;

public class CountryGDPList {
	
	String countryName="";
	String countryCode="";
	String unit="";
	String year ="";
	Double gpd =0D;
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public Double getGpd() {
		return gpd;
	}
	public void setGpd(Double gpd) {
		this.gpd = gpd;
	}
	@Override
	public String toString() {
		return "CountryGDPList [countryName=" + countryName + ", countryCode=" + countryCode + ", unit=" + unit
				+ ", year=" + year + ", gpd=" + gpd + ", getCountryName()=" + getCountryName() + ", getCountryCode()="
				+ getCountryCode() + ", getUnit()=" + getUnit() + ", getYear()=" + getYear() + ", getGpd()=" + getGpd()
				+ "]";
	}

	
	
}
