package com.irctc.checkseatavailablity.dto;

public class TrainData {
	
	private String totalFare="";
	private	String date="";
	private String currentStatus="";
	public String getTotalFare() {
		return totalFare;
	}
	public void setTotalFare(String string) {
		this.totalFare = string;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	@Override
	public String toString() {
		return "TrainData [totalFare=" + totalFare + ", date=" + date + ", currentStatus=" + currentStatus + "]";
	}
	
	

}
