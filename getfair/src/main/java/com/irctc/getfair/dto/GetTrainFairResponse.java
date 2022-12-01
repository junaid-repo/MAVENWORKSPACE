package com.irctc.getfair.dto;

import java.util.ArrayList;

import com.irctc.getfair.dto.TrainData;

public class GetTrainFairResponse {

	private String status;
	private String message;
	private float timestamp;
	ArrayList<TrainData> trainDetails = new ArrayList<TrainData>();

	// Getter Methods

	public String getMessage() {
		return message;
	}

	public float getTimestamp() {
		return timestamp;
	}

	// Setter Methods

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<TrainData> getData() {
		return trainDetails;
	}

	public void setData(ArrayList<TrainData> data) {
		this.trainDetails = data;
	}

	public void setTimestamp(float timestamp) {
		this.timestamp = timestamp;
	}

}
