package com.amazon.ui.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.ui.order.model.Order;
import com.amazon.ui.order.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping("/getOrderList")
	public ModelAndView getOrderList() {
		List<Order> orderList = orderService.getOrderList();
		
		ModelAndView mav = new ModelAndView("/order/orderList");
		mav.addObject("orderList", orderList);
		return mav;
	}
	
}
