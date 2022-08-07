package com.lp.order.service;

import java.util.List;

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

	@Override
	public List<Order> getOrderList() {
		
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(int orderId) {
		
		return orderRepository.findByOrderId(orderId);
	}

}
