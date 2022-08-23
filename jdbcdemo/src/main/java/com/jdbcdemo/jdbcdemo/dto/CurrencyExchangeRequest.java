package com.jdbcdemo.jdbcdemo.dto;

public class CurrencyExchangeRequest {

	String from;
	String to;
	String amount;

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CurrencyExchangeRequest [from=" + from + ", to=" + to + ", amount=" + amount + "]";
	}

}
