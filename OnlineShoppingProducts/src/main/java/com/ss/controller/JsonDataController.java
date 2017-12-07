package com.ss.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.dao.ProductDAO;
import com.ss.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts()
	{
		return productDAO.listActiveProducts();
	}
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id)
	{
		return productDAO.listActiveProductsByCategory(id);
		
	}

}
