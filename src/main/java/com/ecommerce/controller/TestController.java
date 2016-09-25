package com.ecommerce.controller;
 
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.advise.ControllerExceptionHandlerAdvice;
import com.ecommerce.advise.UserExceptions;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.model.Product;

@RestController
@RequestMapping(value = "/user")
public class TestController {
	 
	 
	@Autowired
	private ProductDao dao;
	
	public TestController() {
		System.out.println("Hello World...");
	}
	@RequestMapping("/home")
	public String home(){
		return "/WEB-INF/views/resources/index.html";
	}
	@RequestMapping("/list")
	@ResponseBody
	public List<Product> getProducts(){
		List<Product> list=dao.getAllProducts();
		return list;
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	public void addProduct(@RequestBody Product product){
		dao.addProduct(product);
	}
	@RequestMapping(value="/pagination",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Product>> getProductPagination(@RequestBody Product product){
		List<Product> list=null;
		if (product.getPaginationFirstIndex()<0) {
			return new ResponseEntity<List<Product>>(list,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}else{
			list=dao.getProductsByPagination(product.getPaginationFirstIndex(), product.getPaginationMaxIndex());
			return new ResponseEntity<List<Product>>(list,
					HttpStatus.OK);
		}
	}
}
