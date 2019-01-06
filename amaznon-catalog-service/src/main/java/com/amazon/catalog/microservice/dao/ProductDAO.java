package com.amazon.catalog.microservice.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.amazon.catalog.microservice.model.Product;

@Repository
public class ProductDAO extends CatalogRepository {
	
	private static final String PRODUCTS_BY_CATALOG = "SELECT catalogId, productCode, productDesc, productColor, name, unitsInStock, price, supplierId FROM product WHERE catalogId = ? ORDER BY productDesc ASC";
	
	public List<Product> getProductListByCatalog(Product product) {
		
		String catalogId = product.getCatalogId();
		List<Product> productsByCatalog = new ArrayList<>();
		
		Object[] params = {catalogId};
		int[] sqlTypes = {Types.VARCHAR};
		
		productsByCatalog = (List<Product>) jdbcTemplate.query(PRODUCTS_BY_CATALOG, params, sqlTypes, new BeanPropertyRowMapper<>(Product.class));
		
		return productsByCatalog;
	}
	
	public Product getProductDetails(Product product) {
		
		String productCode = product.getProductCode();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT catalogId, productCode, productDesc, productColor, name, unitsInStock, price, supplierId ");
		sb.append("FROM product ");
		sb.append("WHERE productCode = ? ");
		
		Object[] params = {productCode};
		int[] sqlTypes = {Types.VARCHAR};
		
		product = (Product) jdbcTemplate.queryForObject(sb.toString(), params, sqlTypes, new BeanPropertyRowMapper<>(Product.class));
		
		return product;
	}
	
	public int addProductDetails(Product product) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		Object[] params = {product.getCatalogId(), product.getProductCode(), product.getProductDesc(), product.getProductColor(), product.getName(), product.getUnitsInStock(), product.getPrice(), product.getSupplierId()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}
	
	public int updateProductDetails(Product product) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE product ");
		sb.append("SET productDesc = ?, ");
		sb.append(" productColor = ?, ");
		sb.append(" name = ?, ");
		sb.append(" unitsInStock = ?, ");
		sb.append(" price =  ?, ");
		sb.append(" supplierId = ? ");
		sb.append("WHERE ");
		sb.append(" productCode = ? ");
		
		
		Object[] params = {product.getProductDesc(), product.getProductColor(), product.getName(), product.getUnitsInStock(), product.getPrice(), product.getSupplierId(), product.getProductCode()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}
	
	public int updateProductQuantity(Product product) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE product ");
		sb.append("SET ");
		sb.append(" unitsInStock = ? ");
		sb.append("WHERE ");
		sb.append(" productCode = ? ");
		
		
		Object[] params = {product.getUnitsInStock(), product.getProductCode()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}

}
