package com.ss.test;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ss.dao.ProductDAO;
import com.ss.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDao;
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.ss");
		context.refresh();
		productDao=(ProductDAO) context.getBean("productDao");
	}

	@Test
	public void testCrudProduct()
	{
		/*//adding product
		product=new Product();
		product.setName("Naresh Product");
		product.setBrand("Naresh Brand");
		product.setDescription("Naresh Description");
		product.setUnitPrice(30000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		product=new Product();
		product.setName("Naresh1 Product");
		product.setBrand("Naresh1 Brand");
		product.setDescription("Naresh1 Description");
		product.setUnitPrice(300010);
		product.setActive(true);
		product.setCategoryId(2);
		product.setSupplierId(2);
		
		assertEquals("something happen wrong while inserting",true,productDao.add(product));
		*/
		//getting and updating		
		 product=productDao.get(38);
		 product.setCategoryId(2);
		 assertEquals("something happen wrong while Updating", true,productDao.update(product));
		 
		/* //deleting product
		 product=productDao.get(2);
		 assertEquals("something happen wrong while Deleting", true,productDao.delete(product));
		 
		//list all products		 
		 assertEquals("something happen wrong while Listing",9,productDao.list().size());
*/}
	
	/*@Test
	public void testActiveProducts()
	{
		assertEquals("something happen wrong while Listing",4,productDao.listActiveProducts().size());
	}
	@Test
	public void testActiveProductsByCategory()
	{
		assertEquals("something happen wrong while Listing",2,productDao.listActiveProductsByCategory(3).size());
	}
	@Test
	public void testGetLatestActiveProducts()
	{
		assertEquals("something happen wrong while Listing",3,productDao.getLatestActiveProducts(3).size());
	}*/
	
}
