package com.jdbcdemo.jdbcdemo.dto;

public class OrderPaymentRequest {
	
	String orderNumber="";
	String customerCode="";
	Double orderAmount=0D;
	Double paymentAmount=0D;
	String paymentMethod="";
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public Double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}
	public Double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "OrderPaymentRequest [orderNumber=" + orderNumber + ", customerCode=" + customerCode + ", orderAmount="
				+ orderAmount + ", paymentAmount=" + paymentAmount + ", paymentMethod=" + paymentMethod
				+ ", getOrderNumber()=" + getOrderNumber() + ", getCustomerCode()=" + getCustomerCode()
				+ ", getOrderAmount()=" + getOrderAmount() + ", getPaymentAmount()=" + getPaymentAmount()
				+ ", getPaymentMethod()=" + getPaymentMethod() + "]";
	}
	
	
	
	
			

}
