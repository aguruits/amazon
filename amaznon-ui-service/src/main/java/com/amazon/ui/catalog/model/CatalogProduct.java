package com.amazon.ui.catalog.model;

import java.util.List;
import java.util.ArrayList;

public class CatalogProduct {
	private String catalogId;
	
	private Catalog catalog;
	private List<Product> productList = new ArrayList<>();
	
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public Catalog getCatalog() {
		return catalog;
	}
	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}
