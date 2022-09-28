package com.jdbcdemo.jdbcdemo.dto;

public class PincodeDetails2 {

	private String pin = "400001";
	private String office = "Town Hall S.O (Mumbai)";
	private String office_type = "S.O";
	private String delivery = "Non-Delivery";
	private String division = "Mumbai  South";
	private String region = "Mumbai";
	private String circle = "Maharashtra";
	private String taluk = "Mumbai";
	private String district = "Mumbai";
	private String state_id = "19";
	private String phone = "022-22660701";
	private String related_suboffice = "Not Available";
	private String related_headoffice = "Mumbai G.P.O. ";
	private String longitude = "Not Available";
	private String latitude = "Not Available";
	private String trainNo = "";

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getOffice_type() {
		return office_type;
	}

	public void setOffice_type(String office_type) {
		this.office_type = office_type;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getTaluk() {
		return taluk;
	}

	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState_id() {
		return state_id;
	}

	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRelated_suboffice() {
		return related_suboffice;
	}

	public void setRelated_suboffice(String related_suboffice) {
		this.related_suboffice = related_suboffice;
	}

	public String getRelated_headoffice() {
		return related_headoffice;
	}

	public void setRelated_headoffice(String related_headoffice) {
		this.related_headoffice = related_headoffice;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	@Override
	public String toString() {
		return "PincodeDetails2 [pin=" + pin + ", office=" + office + ", office_type=" + office_type + ", delivery="
				+ delivery + ", division=" + division + ", region=" + region + ", circle=" + circle + ", taluk=" + taluk
				+ ", district=" + district + ", state_id=" + state_id + ", phone=" + phone + ", related_suboffice="
				+ related_suboffice + ", related_headoffice=" + related_headoffice + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", trainNo=" + trainNo + "]";
	}

}
