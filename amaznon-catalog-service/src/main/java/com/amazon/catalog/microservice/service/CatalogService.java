package com.amazon.catalog.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.catalog.microservice.dao.CatalogDAO;
import com.amazon.catalog.microservice.model.Catalog;

@Service
public class CatalogService {
	
	@Autowired
	CatalogDAO catalogDAO;
	
	public List<Catalog> getCatalogList() {
		return catalogDAO.getCatalogList();
	}
	
	public Catalog getCatalogDetails(Catalog catalog) {
		return catalogDAO.getCatalogDetails(catalog);
	}
	
}
