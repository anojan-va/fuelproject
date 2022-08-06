package com.lp.order.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.lp.order.model.OrderEvent;
import com.lp.order.service.AllocationUpdateService;
import com.lp.order.service.DeliveryUpdateService;
import com.lp.order.service.SchduleUpdateService;



@Service
public class DeliveryConsumer{
	
	
	
	@Autowired
	DeliveryUpdateService deliveryUpdateService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryConsumer.class);
	
	@KafkaListener(topics="${spring.kafka.topic.name-delivery}",groupId="${spring.kafka.consumer.group-delivery-id}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("Schdule event received in order service => %s", event.toString()));
		
		System.out.println("order ID is "+event.getOrder().getOrderId());
		deliveryUpdateService.updateDeliveryStatus(event);
		
		
	}
	

}