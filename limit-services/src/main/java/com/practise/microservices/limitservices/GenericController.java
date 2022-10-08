package com.practise.microservices.limitservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.microservices.limitservices.beans.CurrencyServiceConfiguration;
import com.practise.microservices.limitservices.beans.Limits;
import com.practise.microservices.limitservices.config.Configurations;

@RestController
@Controller
public class GenericController {

	@Autowired
	Configurations config;

	@Autowired
	CurrencyServiceConfiguration currconfig;

	@GetMapping("/limits")
	Limits retrieveLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
	}

	@GetMapping("/currency-config")
	CurrencyServiceConfiguration currencyConfig() {
		return currconfig;
	}
	
	@RequestMapping("/welcome-jsp")
	String welcomeJsp() {
		return "welcomeTest";
	}
}
