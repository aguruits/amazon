package com.amazon.catalog.microservice.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.catalog.microservice.model.Catalog;
import com.amazon.catalog.microservice.model.CatalogProduct;
import com.amazon.catalog.microservice.model.Product;
import com.amazon.catalog.microservice.service.CatalogProductService;

@RestController
public class CatalogServiceEndpoint {
	
	@Autowired
	CatalogProductService catalogProductService;
	
	@PostMapping("/getCatalogList")
	public List<Catalog> getCatalogList() {
		return catalogProductService.getCatalogList();
	}
	
	@PostMapping("/getProductsByCatalog")
	public CatalogProduct getProductListByCatalog(@RequestBody CatalogProduct catalogProduct) {
		return catalogProductService.getProductListByCatalog(catalogProduct);
	}
	
	@PostMapping("/getProductDetails")
	public Product getProductDetails(@RequestBody Product product) {
		return catalogProductService.getProductDetails(product);
	}
	
	@PostMapping("/addProductDetails")
	public int addProductDetails(@RequestBody Product product) {
		return catalogProductService.addProductDetails(product);
	}
	
	@PostMapping("/updateProductDetails")
	public int updateProductDetails(@RequestBody Product product) {
		return catalogProductService.updateProductDetails(product);
	}
	
	@PostMapping("/updateProductQuantity")
	public int updateProductQuantity(@RequestBody Product product) {
		return catalogProductService.updateProductQuantity(product);
	}
}
