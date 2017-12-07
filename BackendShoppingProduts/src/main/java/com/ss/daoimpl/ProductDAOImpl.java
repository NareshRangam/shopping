package com.ss.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ss.dao.ProductDAO;
import com.ss.dto.Product;
@Repository("productDao")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//getting list of all products
	@Override
	public List<Product> list() {
	
		try{
			return sessionFactory
					.getCurrentSession()
					.createQuery("from Product",Product.class)
					.getResultList();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	//getting single product based on id
	@Override
	public Product get(int productId) {
		try{
			return sessionFactory
					.getCurrentSession()
					.get(Product.class, Integer.valueOf(productId));
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

	//Update product details
	@Override
	public boolean update(Product product) {
		try{
			sessionFactory
			.getCurrentSession()
			.update(product);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
			
	}
	//deleting the product
	@Override
	public boolean delete(Product product) {
		try
		{
			product.setActive(false);
			return this.update(product);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	//adding the products
	@Override
	public boolean add(Product product) {
		try{
			sessionFactory
			.getCurrentSession()
			.persist(product);
			return true;
		}
	catch(Exception e)
		{
		e.printStackTrace();
		return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String activeProducts="from Product where active=:active";
		return sessionFactory
				.getCurrentSession()
				.createQuery(activeProducts,Product.class)
				.setParameter("active", true)
				.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String activeProducts="from Product where active=:active and categoryId=:categoryId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(activeProducts,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		return sessionFactory
				.getCurrentSession().createQuery("from Product where active=:active ORDER BY id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
