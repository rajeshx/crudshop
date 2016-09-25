package com.ecommerce.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		
	}
	@Override
    @Transactional
	public List<Product> getAllProducts() {
		Session session=sessionFactory.getCurrentSession();
		/*1. way using HQL command
		 * 
		 * Query qry=session.createQuery("from Product");
		List<Product> list=qry.list();
		*/
		/*2. Way using Criteria API
		 * 
		 */
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> list=criteria.list();
		System.out.println(list.get(0).getProductName());
		session.flush();
 		return list;
	}
	@Override
    @Transactional
	public List<Product> getProductsByPagination(Integer first,Integer max) {
		Session session=sessionFactory.getCurrentSession();
		/*
		 * Pagination...
		 */
		Criteria criteria=session.createCriteria(Product.class);
		System.out.println(first);
		System.out.println(max);
		criteria.setFirstResult(first);
		criteria.setMaxResults(max);
		List<Product> list=criteria.list();
		session.flush();
 		return list;
	}
	@Override
	public Product getProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
