package com.irctc.getfair.dto;

public class TrainData {
	private String classType = "";
	private String fare = "";

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "TrainData [classType=" + classType + ", fare=" + fare + "]";
	}
}
