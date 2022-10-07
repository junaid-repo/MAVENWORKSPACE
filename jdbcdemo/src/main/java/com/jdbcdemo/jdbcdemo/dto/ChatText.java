package com.jdbcdemo.jdbcdemo.dto;

public class ChatText {
	String text = "";
	
	

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "ChatText [text=" + text + "]";
	}

}
