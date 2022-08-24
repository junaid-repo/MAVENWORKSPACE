package com.jdbcdemo.jdbcdemo.dto;

public class EmailRequest {

	String from = "";
	String to = "";
	String subject = "";
	String mailBody = "";

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	@Override
	public String toString() {
		return "EmailRequest [from=" + from + ", to=" + to + ", subject=" + subject + ", mailBody=" + mailBody + "]";
	}

}
