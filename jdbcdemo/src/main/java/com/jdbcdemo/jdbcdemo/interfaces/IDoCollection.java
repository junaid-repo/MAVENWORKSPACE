package com.jdbcdemo.jdbcdemo.interfaces;

import com.jdbcdemo.jdbcdemo.dto.OrderPaymentRequest;
import com.jdbcdemo.jdbcdemo.dto.OrderPaymentResponse;

public interface IDoCollection {
	
	
	OrderPaymentResponse doCollection(OrderPaymentRequest request);

}
