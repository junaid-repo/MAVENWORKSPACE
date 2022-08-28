package com.jdbcdemo.jdbcdemo.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
	
	private String customerCode="";
	private String employeeCode="";
	
	List<OrderItemsRequest> orderItems = new ArrayList<>();
	
	
	

}
