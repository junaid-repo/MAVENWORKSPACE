package com.jdbcdemo.jdbcdemo.dto;

public class BaseInput {
	
	String userCode ="";
	String roleCode ="";
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	@Override
	public String toString() {
		return "BaseInput [userCode=" + userCode + ", roleCode=" + roleCode + "]";
	}
	
	

}
