package com.chat.chatapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.jdbcdemo.jdbcdemo.dto.BaseOutput;

public class ChatResponseData extends BaseOutput{
	
	private List<ChatResponseInnerDetails> chatHistory=new ArrayList<>();

	public List<ChatResponseInnerDetails> getChatHistory() {
		return chatHistory;
	}

	public void setChatHistory(List<ChatResponseInnerDetails> chatHistory) {
		this.chatHistory = chatHistory;
	}

	@Override
	public String toString() {
		return "ChatResponseDto [chatHistory=" + chatHistory + "]";
	}
	
	

}
