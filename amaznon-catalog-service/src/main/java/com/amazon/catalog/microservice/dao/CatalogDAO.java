package com.amazon.catalog.microservice.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.amazon.catalog.microservice.model.Catalog;

@Repository
public class CatalogDAO extends CatalogRepository{
	
	@Autowired
	ProductDAO productDAO;
	
	private static final String CATALOG_LIST = "SELECT catalogId, catalogName, catalogDesc from catalog ORDER BY catalogName ASC";
	private static final String CATALOG_DETAILS = "SELECT catalogId, catalogName, catalogDesc from catalog WHERE catalogId = ?";
	
	public List<Catalog> getCatalogList() {
		List<Catalog> catalogList = (List<Catalog>) jdbcTemplate.query(CATALOG_LIST, new BeanPropertyRowMapper<>(Catalog.class));
		return catalogList;
	}
	
	public Catalog getCatalogDetails(Catalog catalog) {
		
		String catalogId = catalog.getCatalogId();
		
		Object[] params = {catalogId};
		int[] sqlTypes = {Types.VARCHAR};
		
		catalog = (Catalog) jdbcTemplate.queryForObject(CATALOG_DETAILS, params, sqlTypes, new BeanPropertyRowMapper<>(Catalog.class));
		
		return catalog;
	}


}

