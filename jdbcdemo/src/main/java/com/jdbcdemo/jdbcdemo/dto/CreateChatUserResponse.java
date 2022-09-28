package com.jdbcdemo.jdbcdemo.dto;

public class CreateChatUserResponse extends BaseOutput{
	
	private String userCode="";
	private String status="";
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CreateChatUserResponse [userCode=" + userCode + ", status=" + status + ", getUserCode()="
				+ getUserCode() + ", getStatus()=" + getStatus() + ", getErrorCode()=" + getErrorCode()
				+ ", getErrorDesc()=" + getErrorDesc() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	

}
