 package com.lp.order.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name ="orders")
@Data
public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	private int orderId;
	@Column(name="gas_station_id")
	private String gasStationId;
	@Column(name="fuel_type")
	private String fuelType;
	@Column(name="qty")
	private int quantity;
	@Column(name="order_status")
	private String orderStatus="Ordered";
	@Column(name="status_date")
	private LocalDate statusDate=LocalDate.now();
	@Column(name="allocation_id")
	private int allocationId;
	@Column(name="schedule_id")
	private int scheduleId;
	@Column(name="dispatch_id")
	private int dispatchId;
	@Column(name="delivery_id")
	private int deliveryId;
	

}
