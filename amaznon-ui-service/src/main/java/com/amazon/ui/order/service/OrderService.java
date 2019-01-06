package com.amazon.ui.order.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.ui.catalog.model.Product;
import com.amazon.ui.catalog.service.CatalogContract;
import com.amazon.ui.order.model.Order;
import com.amazon.ui.user.model.User;
import com.amazon.ui.user.service.UserContract;

@Service
public class OrderService {

	@Autowired
	OrderContract orderContract;
	
	@Autowired
	UserContract userContract;
	
	@Autowired
	CatalogContract catalogContract;
	
	public List<Order> getOrderList() {
		
		List<Order> orderList = orderContract.getOrderList();
		List<Order> orders = new ArrayList<>();
		
		if(orderList != null && orderList.size() > 0) {
			
			orders = orderList.stream()
					.map( productMap -> {
						productMap.setProductDesc(getProductDesc(productMap.getProductCode()));
						return productMap;
					}).map( userMap -> {
						userMap.setUserName(getUserName(userMap.getUserId()));
						return userMap;
					}).map( userMap -> {
					    BigDecimal totalPrice = new BigDecimal(BigInteger.ZERO,  2);
						int quantity = userMap.getQuantity();
						BigDecimal unitPrice = userMap.getUnitPrice();
						BigDecimal totalPriceBig = unitPrice.multiply(new BigDecimal(quantity)); 
						totalPrice = totalPriceBig.add(totalPrice);
						userMap.setTotalPrice(totalPrice);
						userMap.setUserName(getUserName(userMap.getUserId()));
						return userMap;
					}).collect(Collectors.toList());
		}
		
		
		return orders;
	}
	
	private String getUserName(String userId) {
		String userName = null;
		User user = new User();
		user.setUserId(userId);
		user = userContract.getUser(user);
		if(user != null) {
			userName = user.getUserName();
		}
		
		return userName;		
	}
	
	private String getProductDesc(String productCode) {
		String productDesc = null;
		Product product = new Product();
		product.setProductCode(productCode);
		product = catalogContract.getProductDetails(product);
		if(product != null) {
			productDesc = product.getProductDesc();
		}
		
		return productDesc;		
	}
}
