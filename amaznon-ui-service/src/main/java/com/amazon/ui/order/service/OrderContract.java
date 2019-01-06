package com.amazon.ui.order.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amazon.ui.order.model.Order;

@FeignClient(name="ORDER")
public interface OrderContract {

	@PostMapping("/getOrderList")
	public List<Order> getOrderList();
	
	@PostMapping("/getOrderDetails")
	public Order getOrderDetails(@RequestBody Order order);
	
	@PostMapping("/addOrderDetails")
	public int addOrderDetails(@RequestBody Order order);
}
