package com.jdbcdemo.chatservices;

import com.jdbcdemo.jdbcdemo.dto.CreateChatUserRequest;
import com.jdbcdemo.jdbcdemo.dto.CreateChatUserResponse;
import com.jdbcdemo.jdbcdemo.interfaces.ChatInterface;

public abstract class ChatAbsServices implements ChatInterface {

	public abstract CreateChatUserResponse createUser(CreateChatUserRequest request);

}
