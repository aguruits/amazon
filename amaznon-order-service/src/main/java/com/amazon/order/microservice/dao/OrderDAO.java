package com.amazon.order.microservice.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.amazon.order.microservice.model.Order;

@Repository
public class OrderDAO extends OrderRepository{
	
	private static final String ORDER_LIST = "SELECT orderId, productCode, userId, quantity, unitPrice from user_product_order ORDER BY orderId ASC";
	
	public List<Order> getOrderList() {
		
		List<Order> orderList = (List<Order>) jdbcTemplate.query(ORDER_LIST, new BeanPropertyRowMapper<>(Order.class));
		return orderList;
	}
	
	public Order getOrderDetails(Order order) {
		
		String orderId = order.getOrderId();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT orderId, productCode, userId, quantity, unitPrice ");
		sb.append("FROM user_product_order ");
		sb.append("WHERE orderId = ? ");
		
		Object[] params = {orderId};
		int[] sqlTypes = {Types.VARCHAR};
		
		order = (Order) jdbcTemplate.queryForObject(sb.toString(), params, sqlTypes, new BeanPropertyRowMapper<>(Order.class));
		
		return order;
	}
	
	public int addOrderDetails(Order order) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO user_product_order VALUES (?, ?, ?, ?, ?)");
		
		Object[] params = {order.getOrderId(), order.getProductCode(), order.getUserId(), order.getQuantity(), order.getUnitPrice()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.BIGINT};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}


}

