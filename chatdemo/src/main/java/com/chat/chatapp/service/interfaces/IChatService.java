package com.chat.chatapp.service.interfaces;

import com.chat.chatapp.dto.ChatRequestData;
import com.chat.chatapp.dto.ChatResponseData;

@FunctionalInterface
public interface IChatService {

	ChatResponseData addChat(ChatRequestData request);

}
