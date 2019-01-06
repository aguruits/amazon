package com.amazon.ui.catalog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.amazon.ui.catalog.model.Catalog;
import com.amazon.ui.catalog.model.CatalogProduct;
import com.amazon.ui.catalog.model.Product;
import com.amazon.ui.catalog.service.CatalogContract;
import com.amazon.ui.order.model.Order;
import com.amazon.ui.order.service.OrderContract;
import com.amazon.ui.user.model.User;

@Controller
@PropertySource("classpath:micro-services-config.properties")
public class CatalogController {
	
	@Value("${catalog-service-uri}")
	private String catalogServiceURI;
	
	@Autowired
	CatalogContract catalogContract;
	
	@Autowired
	OrderContract orderContract;
	
	@RequestMapping("/getCatalogList")
	public ModelAndView getCatalogList() {
		List<Catalog> catalogList = catalogContract.getCatalogList();
		
		ModelAndView mav = new ModelAndView("/catalog/catalogList");
		mav.addObject("catalogList", catalogList);
		return mav;
	}
	
	@RequestMapping("/getProductsByCatalogPathVariable/{catalogId}")
	public ModelAndView getProductsByCatalogPathVariable(@PathVariable("catalogId") String catalogId ) {
		
		CatalogProduct catalogProduct = new CatalogProduct();
		catalogProduct.setCatalogId(catalogId);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CatalogProduct> catalogProductResponseEntity = restTemplate.postForEntity(catalogServiceURI+"getProductsByCatalog", catalogProduct, CatalogProduct.class);
		catalogProduct = catalogProductResponseEntity.getBody();
		
		ModelAndView mav = new ModelAndView("/catalog/productListByCatalog");
		mav.addObject("catalogProduct", catalogProduct);
		return mav;
	}
	
	@RequestMapping("/getProductsByCatalog")
	public ModelAndView getProductsByCatalog(@QueryParam("catalogId") String catalogId ) {
		
		CatalogProduct catalogProduct = new CatalogProduct();
		catalogProduct.setCatalogId(catalogId);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CatalogProduct> catalogProductResponseEntity = restTemplate.postForEntity(catalogServiceURI+"getProductsByCatalog", catalogProduct, CatalogProduct.class);
		catalogProduct = catalogProductResponseEntity.getBody();
		
		ModelAndView mav = new ModelAndView("/catalog/productListByCatalog");
		mav.addObject("catalogProduct", catalogProduct);
		return mav;
	}
	
	@RequestMapping("/getProductDetails")
	public ModelAndView getProductDetails(@QueryParam("productCode") String productCode ) {
		
		Product product = new Product();
		product.setProductCode(productCode);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product> catalogProductResponseEntity = restTemplate.postForEntity(catalogServiceURI+"getProductDetails", product, Product.class);
		product = catalogProductResponseEntity.getBody();
		
		ModelAndView mav = new ModelAndView("/catalog/productDetails");
		mav.addObject("product", product);
		return mav;
	}
	
	@RequestMapping("/updateProductDetails")
	public ModelAndView updateProductDetails(Product product) {
		catalogContract.updateProductDetails(product);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product> catalogProductResponseEntity = restTemplate.postForEntity(catalogServiceURI+"getProductDetails", product, Product.class);
		product = catalogProductResponseEntity.getBody();
		
		ModelAndView mav = new ModelAndView("/catalog/productDetails");
		mav.addObject("product", product);
		mav.addObject("recordUpdateFlag", "true");
		return mav;
	}
	
	@RequestMapping("/orderProduct")
	public ModelAndView orderProduct(@QueryParam("productCode") String productCode ) {
		
		Product product = new Product();
		product.setProductCode(productCode);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product> catalogProductResponseEntity = restTemplate.postForEntity(catalogServiceURI+"getProductDetails", product, Product.class);
		product = catalogProductResponseEntity.getBody();
		
		Order order = new Order();
		order.setProduct(product);
		order.setProductCode(product.getProductCode());
		order.setUnitPrice(product.getPrice());
		ModelAndView mav = new ModelAndView("/catalog/orderProduct");
		mav.addObject("order", order);
		return mav;
	}
	
	@RequestMapping("/submitOrderProduct")
	public ModelAndView submitOrderProduct(HttpServletRequest request, Order order) {
		
		Product product = new Product();
		product.setProductCode(order.getProductCode());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Product> catalogProductResponseEntity = restTemplate.postForEntity(catalogServiceURI+"getProductDetails", product, Product.class);
		product = catalogProductResponseEntity.getBody();
		
		int unitsInStock = Integer.parseInt(product.getUnitsInStock());
		int quantity = order.getQuantity();
		int quantityToUpdate = unitsInStock - quantity;
		
		Product productToUpdate = new Product();
		productToUpdate.setProductCode(order.getProductCode());
		productToUpdate.setUnitsInStock(String.valueOf(quantityToUpdate));
		catalogContract.updateProductQuantity(productToUpdate);
		
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String userId = user.getUserId();		
		order.setUserId(userId);
		
		orderContract.addOrderDetails(order);
		order.setProduct(product);
		order.setProductCode(product.getProductCode());
		order.setUnitPrice(product.getPrice());
		
		ModelAndView mav = new ModelAndView("/catalog/orderProduct");
		mav.addObject("successOrderFlag", "true");
		mav.addObject("order", order);
		return mav;
	}

}
