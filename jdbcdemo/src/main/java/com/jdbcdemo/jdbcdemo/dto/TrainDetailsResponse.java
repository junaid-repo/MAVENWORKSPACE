package com.jdbcdemo.jdbcdemo.dto;

public class TrainDetailsResponse {

	public String trainNumber = "";
	public String trainDetails = "";

	@Override
	public String toString() {
		return "TrainDetailsResponse [trainNumber=" + trainNumber + ", trainDetails=" + trainDetails + "]";
	}
}
