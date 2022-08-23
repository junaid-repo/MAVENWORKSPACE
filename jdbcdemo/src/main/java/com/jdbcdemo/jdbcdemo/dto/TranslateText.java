package com.jdbcdemo.jdbcdemo.dto;

public class TranslateText {

	private String text = "Hello There, you have not entered any text";

	private String from = "";
	private String to = "";

	public String getText() {
		return text;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "TranslateText [text=" + text + ", from=" + from + ", to=" + to + "]";
	}

}
