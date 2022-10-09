package com.micropractise.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionControlller {

	@Autowired
	private Environment environment;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyCoonversion = responseEntity.getBody();
		System.out.println(currencyCoonversion.getConversionMultiple());
		// Float
		// totalAmt=currencyCoonversion.getConversionMultiple()*(BigDecimal.valueOf(quantity));

		CurrencyConversion currencyExchange = new CurrencyConversion(2345L, "USD", "INR",
				currencyCoonversion.getConversionMultiple(), BigDecimal.valueOf(3),
				quantity.multiply(currencyCoonversion.getConversionMultiple()));
		// String port=environment.getProperty("local.server.port");
		// currencyExchange.setEnvironment(port);
		return currencyExchange;
	}

}
