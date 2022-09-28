package com.jdbcdemo.jdbcdemo.interfaces;

import com.jdbcdemo.jdbcdemo.dto.CreateChatUserRequest;
import com.jdbcdemo.jdbcdemo.dto.CreateChatUserResponse;

public interface ChatInterface {
	
	CreateChatUserResponse createUser(CreateChatUserRequest request);

}
