package com.chat.chatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatappApplication {

	public static void main(String[] args) {
		System.out.println("Entering the main method of chatapp");
		SpringApplication.run(ChatappApplication.class, args);
	}

}
