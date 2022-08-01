package com.lp.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lp.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
