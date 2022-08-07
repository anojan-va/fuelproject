package com.lp.order.service;

import java.util.List;

import com.lp.order.model.Order;


public interface OrderService {
	
	// save the order
	Order save(Order order);
	
	// get list of orders
	List<Order> getOrderList();
	
	Order getOrderById(int orderId);

}


