package com.jdbcdemo.jdbcdemo.dto;

public class OrderPaymentResponse extends BaseOutput{
	
	String orderNumber="";
	String paymentNumber="";
	String paymentStatus="";
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getPaymentNumber() {
		return paymentNumber;
	}
	public void setPaymentNumber(String paymentNumber) {
		this.paymentNumber = paymentNumber;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "OrderPaymentResponse [orderNumber=" + orderNumber + ", paymentNumber=" + paymentNumber
				+ ", paymentStatus=" + paymentStatus + "]";
	}

}
