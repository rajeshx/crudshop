package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public Product getProduct(String id);
	public List<Product> getAllProducts();
	public void deleteProduct(Product product);
	public List<Product> getProductsByPagination(Integer first,Integer max);
	
	
	
}
