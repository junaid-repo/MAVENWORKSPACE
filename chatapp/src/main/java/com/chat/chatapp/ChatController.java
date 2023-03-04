package com.chat.chatapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chat.chatapp.dto.CUserRequest;
import com.chat.chatapp.dto.CUserResponse;
import com.chat.chatapp.dto.ChatRequestDto;
import com.chat.chatapp.dto.ChatResponseDto;
import com.chat.chatapp.service.ImplChatServices;
import com.chat.chatapp.service.interfaces.ChatServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jdbcdemo.URIConstants;
import com.jdbcdemo.jdbcdemo.dto.BaseOutput;
import com.jdbcdemo.jdbcdemo.interfaces.IServices;
import com.jdbcdemo.service.Services;

import utility.Utility;

@RestController
public class ChatController {
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	/*
	 * @RequestMapping(value = "/chat/createUser", method = RequestMethod.GET)
	 * ResponseEntity<CUserResponse> createChatUser(@RequestBody CUserRequest
	 * request) { CUserResponse response = new CUserResponse();
	 * 
	 * return new ResponseEntity<CUserResponse>(response, HttpStatus.CREATED); }
	 */

	/*
	 * @RequestMapping(value = "/chat/startChat", method = RequestMethod.POST)
	 * ResponseEntity<ChatResponseDto> startChat2(@RequestBody ChatRequestDto
	 * request) {
	 * 
	 * ChatResponseDto response = new ChatResponseDto();
	 * 
	 * ImplChatServices csi = new ImplChatServices(); response =
	 * csi.addChat(requestttttttt);
	 * 
	 * return new ResponseEntity<ChatResponseDto>(response, HttpStatus.CREATED);
	 * 
	 * }
	 */
	@RequestMapping(value ="/chat/startChat", method = RequestMethod.POST)
	ResponseEntity<BaseOutput> startChat(@RequestBody ChatRequestDto request) throws JsonProcessingException {
		ChatResponseDto response = new ChatResponseDto();

		ImplChatServices csi = new ImplChatServices();
		try {
			response = csi.addChat(request);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorDesc(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
			response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			System.out.println("ar");
			return new ResponseEntity<BaseOutput>(response, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		response.setErrorDesc(HttpStatus.OK.getReasonPhrase());
		response.setErrorCode(HttpStatus.OK.value());
		Utility.insertInternalApiLogs(URIConstants.REMOVE_EMPLOYEE, ow.writeValueAsString(request),
				ow.writeValueAsString(response));
		return new ResponseEntity<BaseOutput>(response, HttpStatus.OK);
	}
}
