package com.chat.chatapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;

public class ChatResponseDto extends BaseOutput{
	
	private List<ChatResponseDetails> chatHistory=new ArrayList<>();

	public List<ChatResponseDetails> getChatHistory() {
		return chatHistory;
	}

	public void setChatHistory(List<ChatResponseDetails> chatHistory) {
		this.chatHistory = chatHistory;
	}

	@Override
	public String toString() {
		return "ChatResponseDto [chatHistory=" + chatHistory + "]";
	}
	
	

}
