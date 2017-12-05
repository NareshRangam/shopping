package com.ss.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ss.dao.CategoryDAO;
import com.ss.dto.Category;

@Repository("categoryDao")
public class CategoryDAOImpl implements CategoryDAO {
	
	
	private static List<Category> categories=new ArrayList<Category>();
	
	static{
		 //first category
		Category category=new Category();
		category.setId(1);
		category.setName("TV");
		category.setDescription("description for TV");
		category.setImageURL("tv.png");
		
		categories.add(category);
		
		 //second category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("description for Mobile");
		category.setImageURL("Mobile.png");
		
		categories.add(category);
		
		 //third category
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("description for Laptop");
		category.setImageURL("Laptop.png");
		
		categories.add(category);
		}

	@Override
	public List<Category> list() {
		
		return categories;
	}

	@Override
	public Category get(int id) {
		
		//enhanced for loop
		for(Category category:categories)
		{
			if(category.getId()==id) return category;
		}
		return null;
	}

}
