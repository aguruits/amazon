package com.amazon.order.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.order.microservice.dao.OrderDAO;
import com.amazon.order.microservice.model.Order;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	public List<Order> getOrderList() {
		return orderDAO.getOrderList();
	}
	
	public Order getOrderDetails(Order order) {
		return orderDAO.getOrderDetails(order);
	}
	
	public int addOrderDetails(Order order) {
		return orderDAO.addOrderDetails(order);
	}

}
