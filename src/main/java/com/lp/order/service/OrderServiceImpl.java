package com.lp.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.order.model.Order;
import com.lp.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;

	// overwrite save method
	@Override
	public Order save(Order order) {
		
		return orderRepository.save(order);
		
	}

}
