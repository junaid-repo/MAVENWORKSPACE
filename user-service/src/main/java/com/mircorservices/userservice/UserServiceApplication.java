package com.mircorservices.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
		//entered into the main method of UserServiceApplication

	}

}
