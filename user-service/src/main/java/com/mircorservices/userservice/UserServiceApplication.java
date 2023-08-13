package com.mircorservices.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	Logger log = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
		//entered into the main method of UserServiceApplication

	}

}
