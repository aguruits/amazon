package com.amazon.catalog.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.catalog.microservice.dao.ProductDAO;
import com.amazon.catalog.microservice.model.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductDAO productDAO;
	
	public List<Product> getProductListByCatalog(Product product) {
		List<Product> productList = productDAO.getProductListByCatalog(product);
		return productList;
	}
	
	public List<Product> getProductsByCatalog(Product product) {
		return productDAO.getProductListByCatalog(product);
	}

	public Product getProductDetails(Product product) {
		return productDAO.getProductDetails(product);
	}
	
	public int addProductDetails(Product product) {
		return productDAO.addProductDetails(product);
	}
	
	public int updateProductDetails(Product product) {
		return productDAO.updateProductDetails(product);
	}
	
	public int updateProductQuantity(Product product) {
		return productDAO.updateProductQuantity(product);
	}

}
