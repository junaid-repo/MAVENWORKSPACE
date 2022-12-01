package com.irctc.gettrainbetweenstations.dto;

import java.util.ArrayList;

public class TrainData {
	private String train_number;
	private String train_name;
	private String train_type;
	private String train_origin_station;
	private String train_origin_station_code;
	private String train_destination_station;
	private String train_destination_station_code;
	private String depart_time;
	private String arrival_time;
	private String distance;
	private float day_of_journey;

	// Getter Methods

	public String getTrain_number() {
		return train_number;
	}

	public String getTrain_name() {
		return train_name;
	}

	public String getTrain_type() {
		return train_type;
	}

	public String getTrain_origin_station() {
		return train_origin_station;
	}

	public String getTrain_origin_station_code() {
		return train_origin_station_code;
	}

	public String getTrain_destination_station() {
		return train_destination_station;
	}

	public String getTrain_destination_station_code() {
		return train_destination_station_code;
	}

	public String getDepart_time() {
		return depart_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public String getDistance() {
		return distance;
	}

	public float getDay_of_journey() {
		return day_of_journey;
	}

	// Setter Methods

	public void setTrain_number(String train_number) {
		this.train_number = train_number;
	}

	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}

	public void setTrain_type(String train_type) {
		this.train_type = train_type;
	}

	public void setTrain_origin_station(String train_origin_station) {
		this.train_origin_station = train_origin_station;
	}

	public void setTrain_origin_station_code(String train_origin_station_code) {
		this.train_origin_station_code = train_origin_station_code;
	}

	public void setTrain_destination_station(String train_destination_station) {
		this.train_destination_station = train_destination_station;
	}

	public void setTrain_destination_station_code(String train_destination_station_code) {
		this.train_destination_station_code = train_destination_station_code;
	}

	public void setDepart_time(String depart_time) {
		this.depart_time = depart_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public void setDay_of_journey(float day_of_journey) {
		this.day_of_journey = day_of_journey;
	}
}
