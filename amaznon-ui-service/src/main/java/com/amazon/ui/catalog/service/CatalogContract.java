package com.amazon.ui.catalog.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amazon.ui.catalog.model.Catalog;
import com.amazon.ui.catalog.model.CatalogProduct;
import com.amazon.ui.catalog.model.Product;

@FeignClient(name="CATALOG")
public interface CatalogContract {

	@PostMapping("/getCatalogList")
	public List<Catalog> getCatalogList();
	
	@PostMapping("/getProductsByCatalog")
	public CatalogProduct getProductsByCatalog(@RequestBody CatalogProduct catalogProduct);
	
	@PostMapping("/addProductDetails")
	public int addProductDetails(@RequestBody Product product);
	
	@PostMapping("/updateProductDetails")
	public int updateProductDetails(@RequestBody Product product);
	
	@PostMapping("/getProductDetails")
	public Product getProductDetails(@RequestBody Product product);
	
	@PostMapping("/updateProductQuantity")
	public int updateProductQuantity(@RequestBody Product product);
	
}
