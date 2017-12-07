package com.ss.dao;
import java.util.*;

import com.ss.dto.Product;
public interface ProductDAO {
	List<Product>  list();
	Product get(int productId);
	boolean update(Product product);
	boolean delete(Product product);
	boolean add(Product product);

	
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);

}
