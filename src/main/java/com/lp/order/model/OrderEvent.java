
package com.lp.order.model;




public class OrderEvent {
	
	private String message;
	private String status;
	private Order order;
	
	public OrderEvent(String message, String status, Order order) {
		super();
		this.message = message;
		this.status = status;
		this.order = order;
	}
	
	public OrderEvent() {
		super();
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

}
