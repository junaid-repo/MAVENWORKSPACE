package com.irctc.checkseatavailablity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.checkseatavailablity.dto.SeatAvailabilityResponse;
import com.irctc.checkseatavailablity.external.ExternalService;
import com.irctc.checkseatavailablity.service.RetrieveData;

@RestController
public class GenericContollerSeatCheck {

	@Autowired
	ExternalService serv;

	@GetMapping("/seatAvailability")
	SeatAvailabilityResponse checkSeatAvailibility(@RequestParam String classType, String fromStation, String quota,
			String toStation, String trainNumber, String date) {

		String externalApiData = "";

		SeatAvailabilityResponse response = new SeatAvailabilityResponse();
		externalApiData = serv.checkSeatAvailability(classType, fromStation, quota, toStation, trainNumber, date);
		System.out.println(externalApiData);
		RetrieveData rd = new RetrieveData();
		response = rd.getDataFromJson(externalApiData);

		return response;

	}

}
