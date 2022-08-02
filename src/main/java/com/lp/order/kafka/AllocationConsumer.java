package com.lp.order.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lp.order.model.OrderEvent;
import com.lp.order.service.AllocationUpdateService;



@Service
public class AllocationConsumer{
	
	
	@Autowired
	AllocationUpdateService allocationUpdateService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AllocationConsumer.class);
	
	@KafkaListener(topics="${spring.kafka.topic.name-allocation}",groupId="${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("Order event received in allocation => %s", event.toString()));
		
		System.out.println("order ID is "+event.getOrder().getOrderId());
		allocationUpdateService.updateAllocationStatus(event);
		
		
	}
	

}
