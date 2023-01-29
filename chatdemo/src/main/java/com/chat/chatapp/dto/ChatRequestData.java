package com.chat.chatapp.dto;

import java.time.LocalDate;

public class ChatRequestData {

	private String fromUser = null;
	private String toUser = null;
	private String msg = null;
	private String date = null;

	public ChatRequestData() {

	}

	public String getFromUser() {
		return fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public String getMsg() {
		return msg;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ChatRequest [fromUser=" + fromUser + ", toUser=" + toUser + ", msg=" + msg + ", date=" + date + "]";
	}

}
