package com.amazon.catalog.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.catalog.microservice.model.Catalog;
import com.amazon.catalog.microservice.model.CatalogProduct;
import com.amazon.catalog.microservice.model.Product;

@Service
public class CatalogProductService {
	
	@Autowired
	CatalogService catalogService;
	
	@Autowired
	ProductService productService;
	
	public List<Catalog> getCatalogList() {
		return catalogService.getCatalogList();
	}
	
	public CatalogProduct getProductListByCatalog(CatalogProduct catalogProduct) {
		String catalogId = catalogProduct.getCatalogId();
		
		Catalog catalog = new Catalog();
		catalog.setCatalogId(catalogId);
		catalog = catalogService.getCatalogDetails(catalog);
		catalogProduct.setCatalog(catalog);
		
		Product product = new Product();
		product.setCatalogId(catalogId);
		List<Product> productList = productService.getProductListByCatalog(product);
		catalogProduct.setProductList(productList);	
		
		return catalogProduct;
	}
	
	public Product getProductDetails(Product product) {
		return productService.getProductDetails(product);
	}
	
	public int addProductDetails(Product product) {
		return productService.addProductDetails(product);
	}
	
	public int updateProductDetails(Product product) {
		return productService.updateProductDetails(product);
	}

	public int updateProductQuantity(Product product) {
		return productService.updateProductQuantity(product);
	}
}
