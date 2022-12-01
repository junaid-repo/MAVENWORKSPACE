package com.irctc.gettrainbetweenstations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.gettrainbetweenstations.dto.TrainStationResponse;
import com.irctc.gettrainbetweenstations.external.ExternalService;
import com.irctc.gettrainbetweenstations.service.RetrieveData;

@RestController
public class GenericContollerTrainSchedule {

	@Autowired
	ExternalService serv;

	@GetMapping("/getTrainDetails")
	TrainStationResponse getTrainDetails(@RequestParam String from, String to) {
		String externalApiData = "";

		TrainStationResponse response = new TrainStationResponse();

		response.setMessage(from);
		response.setStatus(to);

		externalApiData = serv.getTrainBetweenStations(from, to);
		System.out.println(externalApiData);
		RetrieveData rd = new RetrieveData();

		try {
			response = rd.getDataFromJson(externalApiData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally {
			System.out.println("inside finally");
		}

		return response;
	}

}
