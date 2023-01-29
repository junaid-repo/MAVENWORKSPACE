package com.chat.chatapp.service.interfaces;

import com.chat.chatapp.dto.ChatRequestDto;
import com.chat.chatapp.dto.ChatResponseDto;

@FunctionalInterface
public interface ChatServiceI {

	ChatResponseDto addChat(ChatRequestDto request);

}
