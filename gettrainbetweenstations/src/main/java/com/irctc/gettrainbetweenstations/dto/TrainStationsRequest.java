package com.irctc.gettrainbetweenstations.dto;

public class TrainStationsRequest {

	private String fromStation = "";
	private String toStation = "";

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	@Override
	public String toString() {
		return "TrainStationsRequest [fromStation=" + fromStation + ", toStation=" + toStation + "]";
	}
	
	
	
}
