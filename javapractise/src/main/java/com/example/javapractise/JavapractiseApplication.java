package com.example.javapractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
public class JavapractiseApplication {

	public static void main(String[] args) {

		SpringApplication.run(JavapractiseApplication.class, args);
		System.out.println("The server should start here");
	}

}
