package com.jdbcdemo.jdbcdemo.dto;

public class SalaryOperationsResponse extends BaseOutput {
	
	private String operation ="";
	private Double amount =0D;
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "SalaryOperationsResponse [operation=" + operation + ", amount=" + amount + ", getOperation()="
				+ getOperation() + ", getAmount()=" + getAmount() + "]";
	}
	

}
