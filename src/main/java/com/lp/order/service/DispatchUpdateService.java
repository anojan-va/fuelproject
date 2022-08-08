package com.lp.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.order.model.Order;
import com.lp.order.model.OrderEvent;
import com.lp.order.repository.OrderRepository;

@Service
public class DispatchUpdateService {
	
	
	@Autowired
	OrderRepository orderRepository;
	
	public void updateDispatchStatus(OrderEvent event) {
		
		System.out.println("Dispatch id:"+event.getOrder().getDispatchId());
		
		// get the order DB and update the order status
		Order updatedOrder = orderRepository.findByOrderId(event.getOrder().getOrderId());
		
		updatedOrder.setOrderStatus(event.getOrder().getOrderStatus());
		updatedOrder.setStatusDate(event.getOrder().getStatusDate());
		
		// save the updated order 
		orderRepository.save(updatedOrder);
	}
	
	

}