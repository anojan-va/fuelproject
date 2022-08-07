package com.lp.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lp.order.kafka.OrderProducer;
import com.lp.order.model.Order;
import com.lp.order.model.OrderEvent;
import com.lp.order.service.OrderService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value="/services")
public class OrderController {
	@Autowired
	OrderProducer orderProducer;
	
	@Autowired
	OrderService orderService;
	
	
	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
		//System.out.println("Test10");
	}


	// save new orders
	@RequestMapping(value="/orders",method =RequestMethod.POST)
	public Order save(@RequestBody Order order) {
		Order order_response= new Order();
		order_response =orderService.save(order);
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setMessage("Order Placed");
		orderEvent.setStatus("sucess");
		orderEvent.setOrder(order_response);
		orderProducer.sendMessage(orderEvent);
				
		return order_response;
		
	}
	
	// List orders 
	@RequestMapping(value="/orders",method =RequestMethod.GET)
	public List<Order> getOrderList(){
		
		return orderService.getOrderList();
	}
	
	// find order by id 
	@RequestMapping(value="/order",method = RequestMethod.GET)
	public Order getOrderById(@RequestParam int orderId) {
		
		return orderService.getOrderById(orderId);
		
	}
	
	
	

}
