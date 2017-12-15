package com.ss.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ss.dao.CategoryDAO;
import com.ss.dto.Category;



public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO categoryDao;
	
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ss");
		context.refresh();
		categoryDao = (CategoryDAO)context.getBean("categoryDao");
	}
	
	
	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Laptop3");
		category.setDescription("This is some description for laptop3!");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
		
		
	}*/
	/*@Test
	public void testGetCategory() {
		category=categoryDao.get(1);
		
		assertEquals("Successfully fetched a category from the table!","Laptop",category.getName());
	}*/
	

	/*@Test
	public void testUpdateCategory() {
		category=categoryDao.get(1);
		category.setName("HP Laptop");
		assertEquals("Successfully Updated a category inside the table!",true,categoryDao.update(category));
	}*/
	
	/*@Test
	public void testDeleteCategory()
	{
		category=categoryDao.get(1);
		assertEquals("Successfully deleted a category from the table!",true,categoryDao.delete(category));
	}*/
	/*@Test
	public void testListCategory()
	{
		assertEquals("Successfully deleted a category from the table!",3,categoryDao.list().size());
	}*/

	
	
	/*Perform CRUD operation*/
	
	@Test
	public void testCRUDCategory()
	{
		//adding category
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
		
		category = new Category();
		category.setName("TV");
		category.setDescription("This is some description for TV!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
		
		/*Fetching & updating category*/
		
		category=categoryDao.get(2);
		category.setName("Philips TV");
		assertEquals("Successfully fetched a category from the table!",true,categoryDao.update(category));
		
		//delete category
		
		category=categoryDao.get(1);
		assertEquals("Successfully deleted a category from the table!",true,categoryDao.delete(category));
		
	/*	list the category*/
		
		assertEquals("Successfully deleted a category from the table!",1,categoryDao.list().size());
	}
	
}