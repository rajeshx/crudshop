package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

public class ProductService {
	@Autowired
	private ProductDao dao;
	
	public List<Product> getAllProducts(){
		return dao.getAllProducts();
	}
	public void addProduct(Product product){
		// avoid duplication
		dao.addProduct(product);
	}
	public void deleteProduct(Product product){
		// check if id already existed or not..
		dao.deleteProduct(product);
	}
	public List<Product> getPriceAscSortedProducts(){
		// logic for ascending sorting
		return dao.getAllProducts();
	}
	public List<Product> getPriceDscSortedProducts(){
		// logic for descending sorting
		return dao.getAllProducts();
	}
}
