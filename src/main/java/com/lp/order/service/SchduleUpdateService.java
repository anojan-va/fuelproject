package com.lp.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.order.model.OrderEvent;
import com.lp.order.repository.OrderRepository;


@Service
public class SchduleUpdateService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public void updateSchduleStatus(OrderEvent event) {
		
		orderRepository.save(event.getOrder());
	}

}
