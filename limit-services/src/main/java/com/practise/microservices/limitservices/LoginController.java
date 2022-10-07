package com.practise.microservices.limitservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practise.microservices.limitservices.beans.CurrencyServiceConfiguration;
import com.practise.microservices.limitservices.config.Configurations;

@Controller
public class LoginController {

	@Autowired
	Configurations config;

	@Autowired
	CurrencyServiceConfiguration currconfig;

	
	
	@RequestMapping("/login")
	String welcomeJsp(@RequestParam String paramName, ModelMap model) {
		model.put("name", paramName);
		return "login";
	}
}
