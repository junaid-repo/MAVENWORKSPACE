package com.chat.chatapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chatapp.dto.CUserRequest;
import com.chat.chatapp.dto.CUserResponse;

@RestController
public class ChatController {

	
	@RequestMapping(value="/chat/createUser", method=RequestMethod.GET)
	ResponseEntity<CUserResponse> createChatUser(@RequestBody CUserRequest request) {
		CUserResponse response = new CUserResponse();
		
		return new ResponseEntity<CUserResponse>(response, HttpStatus.CREATED);
	}
}
