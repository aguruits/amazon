package com.amazon.order.microservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;

}
