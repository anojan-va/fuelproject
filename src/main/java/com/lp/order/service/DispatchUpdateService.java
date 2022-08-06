package com.lp.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.order.model.OrderEvent;
import com.lp.order.repository.OrderRepository;

@Service
public class DispatchUpdateService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public void updateDispatchStatus(OrderEvent event) {
		
		System.out.println("Dispatch id:"+event.getOrder().getDispatchId());
		//orderRepository.save(event.getOrder());
	}

}