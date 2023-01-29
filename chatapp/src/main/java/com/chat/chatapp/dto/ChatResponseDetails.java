package com.chat.chatapp.dto;

import java.time.LocalDate;

public class ChatResponseDetails {

	private String userName = null;
	private String message = null;
	private String status = null;
	private String date = null;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ChatResponseDetails [userName=" + userName + ", message=" + message + ", status=" + status + ", date="
				+ date + "]";
	}

	

}
