package com.shop.products.users.dto;

public class BaseOutput {
	
	private int errorCode;
	private String errorDesc;
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	@Override
	public String toString() {
		return "BaseOutput [errorCode=" + errorCode + ", errorDesc=" + errorDesc + "]";
	}
	
	

}
