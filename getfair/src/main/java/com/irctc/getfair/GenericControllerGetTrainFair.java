package com.irctc.getfair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.getfair.dto.GetTrainFairResponse;
import com.irctc.getfair.external.ExternalService;
import com.irctc.getfair.service.RetrieveData;

@RestController
public class GenericControllerGetTrainFair {
	@Autowired
	ExternalService serv;

	@RequestMapping(value="getTrainFare", method=RequestMethod.GET)
	ResponseEntity<GetTrainFairResponse> getTrainFair(@RequestParam String trainNumber, String fromStation, String toStation) {
		GetTrainFairResponse response = new GetTrainFairResponse();
		String externalApiData = "";
		externalApiData = serv.getTrainFair(trainNumber, fromStation, toStation);
		System.out.println(externalApiData);
		RetrieveData rd = new RetrieveData();
		response = rd.getDataFromJson(externalApiData);

		return new ResponseEntity<GetTrainFairResponse>(response, HttpStatus.OK);

	}

}
