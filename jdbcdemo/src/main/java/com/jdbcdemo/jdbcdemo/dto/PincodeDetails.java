package com.jdbcdemo.jdbcdemo.dto;

public class PincodeDetails {
	
	
	public String pin = "400001";
	public String office = "Town Hall S.O (Mumbai)";
	public String office_type = "S.O";
	public String delivery = "Non-Delivery";
	public String division = "Mumbai  South";
	public String region = "Mumbai";
	public String circle = "Maharashtra";
	public String taluk = "Mumbai";
	public String district = "Mumbai";
	public String state_id = "19";
	public String phone = "022-22660701";
	public String related_suboffice = "Not Available";
	public String related_headoffice = "Mumbai G.P.O. ";
	public String longitude = "Not Available";
	public String latitude = "Not Available";
	public String trainNo="";
	@Override
	public String toString() {
		return "PincodeDetails [pin=" + pin + ", office=" + office + ", office_type=" + office_type + ", delivery="
				+ delivery + ", division=" + division + ", region=" + region + ", circle=" + circle + ", taluk=" + taluk
				+ ", district=" + district + ", state_id=" + state_id + ", phone=" + phone + ", related_suboffice="
				+ related_suboffice + ", related_headoffice=" + related_headoffice + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", trainNo=" + trainNo + "]";
	}

	
	
	
	

}
