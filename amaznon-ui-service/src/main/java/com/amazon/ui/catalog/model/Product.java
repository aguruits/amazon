package com.amazon.ui.catalog.model;

import java.math.BigDecimal;

public class Product {
	
	private String catalogId;
	private String productCode;
	private String productDesc;
	private String productColor;
	private String name;
	private String unitsInStock;
	private BigDecimal price;
	private String supplierId;
	
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(String unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

}
