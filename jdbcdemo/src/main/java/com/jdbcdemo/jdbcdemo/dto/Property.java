package com.jdbcdemo.jdbcdemo.dto;

public class Property {
	String paramName;
	String paramValue;
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	@Override
	public String toString() {
		return "Property [paramName=" + paramName + ", paramValue=" + paramValue + "]";
	}
	

}
