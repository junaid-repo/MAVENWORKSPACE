package com.jdbcdemo.chatservices;

import com.jdbcdemo.jdbcdemo.dto.CreateChatUserRequest;
import com.jdbcdemo.jdbcdemo.dto.CreateChatUserResponse;
import com.jdbcdemo.service.CoreServiceCall;

public class ChatServices extends ChatAbsServices {
	

	@Override
	public CreateChatUserResponse createUser(CreateChatUserRequest request) {
		CreateChatUserResponse response = new CreateChatUserResponse();
		String firstName = request.getFirstName();
		String lastName = request.getLastName();
		String gender = request.getGender();
		String dob = request.getDob();
		String psd = request.getPassword();
		CoreServiceCall core = new CoreServiceCall();
		response = core.createUserForChat(firstName, lastName, gender, dob, psd);
		return response;
	}

}
