package com.practise.microservices.limitservices;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practise.microservices.limitservices.beans.CurrencyServiceConfiguration;
import com.practise.microservices.limitservices.config.Configurations;

@Controller
public class LoginController {

	@Autowired
	Configurations config;

	@Autowired
	CurrencyServiceConfiguration currconfig;
	
	private Logger logger =	LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping(value = "login", method=RequestMethod.GET)
	String login() {
		//model.put("name", paramName);
		//logger.info("The input taken is {} and {} ", paramName, "You are great");
		return "login";
	}

	@RequestMapping(value = "login", method=RequestMethod.POST)
	String welcomeJsp(@RequestParam String name, String pass, ModelMap model) {
		model.put("name", name);
		model.put("pass", pass);
		logger.info("The input taken is {} and {} ", name, "You are great");
		return "welcomeTest";
	}
}
