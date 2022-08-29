package com.jdbcdemo.jdbcdemo.interfaces;

import java.util.Map;

import com.jdbcdemo.jdbcdemo.dto.NewCustomerRequest;

public interface ICompany {
	public Map saveNewCustomer(NewCustomerRequest newCustomer);
	public Map calculateOrderValue(String orderNumber);
	public Map createNewOrder(Map orderDetails);
}
