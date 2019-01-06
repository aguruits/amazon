package com.amazon.order.microservice.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.order.microservice.model.Order;
import com.amazon.order.microservice.service.OrderService;

@RestController
public class OrderServiceEndpoint {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/getOrderList")
	public List<Order> getOrderList() {
		return orderService.getOrderList();
	}
	
	@PostMapping("/getOrderDetails")
	public Order getOrderDetails(@RequestBody Order order) {
		return orderService.getOrderDetails(order);
	}
	
	@PostMapping("/addOrderDetails")
	public int addOrderDetails(@RequestBody Order order) {
		return orderService.addOrderDetails(order);
	}
	
}
