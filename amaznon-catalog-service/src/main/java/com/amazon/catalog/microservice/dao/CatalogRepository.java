package com.amazon.catalog.microservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CatalogRepository {
	
	 @Autowired
	 JdbcTemplate jdbcTemplate;

}
