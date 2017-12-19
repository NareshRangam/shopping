package com.ss.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;
import com.ss.dao.UserDAO;
import com.ss.dto.Address;
import com.ss.dto.Cart;
import com.ss.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDao;
	private static User user=null;
	private static Address address=null;
	private static Cart cart=null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ss");
		context.refresh();
		userDao = (UserDAO)context.getBean("userDao");
	}
	/*
	@Test
	public void testAdd() {
		
		user=new User();
		user.setFirstName("Venkat");
		user.setLastName("Rangam");
		user.setEmail("Naresh@gmail.com");
		user.setContactNumber("12345");
		user.setRole("USER");
		user.setPassword("123");
		//adding User
		assertEquals("Unable to add the User..Something Went Wrong!",true,userDao.addUser(user));
		
		//billing Address
		address=new Address();
		address.setAddressLineOne("31/486,Ramnagar,Dharmavaram");
		address.setAddressLineTwo("Near Water Tank");
		address.setCity("Dharmavaram");
		address.setState("Andhra Pradesh");
		address.setCountry("India");
		address.setPostalCode("5600672");
		//set billing true
		address.setBilling(true);
		
		//link the user with the address
		address.setUserId(user.getId());
		//adding 
		assertEquals("Unable to add the Address..Something Went Wrong!",true,userDao.addAddress(address));
		
		if(user.getRole().equals("USER"))
		{
			cart=new Cart();
			cart.setUser(user);
			//adding the cart
			assertEquals("Unable to add the Cart..Something Went Wrong!",true,userDao.addCart(cart));
			
			//shipping Address
			address=new Address();
			address.setAddressLineOne("31/487,Ramnagar1,Dharmavaram1");
			address.setAddressLineTwo("Near Water Tank1");
			address.setCity("Dharmavaram1");
			address.setState("Andhra Pradesh1");
			address.setCountry("India1");
			address.setPostalCode("56006721");
			//set shipping true
			address.setShipping(true);
			//link it with the user
			address.setUserId(user.getId());
			//adding the cart
			assertEquals("Unable to add the Address..Something Went Wrong!",true,userDao.addAddress(address));	
		}
		
	}
*/
	

	/*@Test
	public void testAdd() {
		
		user=new User();
		user.setFirstName("Venkat");
		user.setLastName("Rangam");
		user.setEmail("Naresh@gmail.com");
		user.setContactNumber("12345");
		user.setRole("USER");
		user.setPassword("123");
		
		if(user.getRole().equals("USER"))
		{
			cart=new Cart();
			cart.setUser(user);
			
			//attach cart to the user
			user.setCart(cart);
		
		}
		//adding the user
		assertEquals("Unable to add the user..Something Went Wrong!",true,userDao.addUser(user));		
	}
*/
	
	/*@Test
	public void testUpdateCart()
	{
		//fetch the user byits mail
		user=userDao.getByEmail("Naresh@gmail.com");
		//get the cart of user
		cart=user.getCart();
		
		cart.setGrandTotal(55555);
		cart.setCartLines(3);
		assertEquals("Unable to Update the Cart..Something Went Wrong!",true,userDao.updateCart(cart));	
	}
*/
	/*@Test
	public void testAddAddress()
	{
		//we need to add the user
		user=new User();
		user.setFirstName("Venkat");
		user.setLastName("Rangam");
		user.setEmail("Naresh@gmail.com");
		user.setContactNumber("12345");
		user.setRole("USER");
		user.setPassword("123");
		assertEquals("Unable to add the USer..Something Went Wrong!",true,userDao.addUser(user));
		
		//we need to add the billing address
		
		address=new Address();
		address.setAddressLineOne("31/486,Ramnagar,Dharmavaram");
		address.setAddressLineTwo("Near Water Tank");
		address.setCity("Dharmavaram");
		address.setState("Andhra Pradesh");
		address.setCountry("India");
		address.setPostalCode("5600672");
		//set billing true
		address.setBilling(true);
		
		address.setUser(user);
		assertEquals("Unable to add the Billing Address..Something Went Wrong!",true,userDao.addAddress(address));
		
		//we need to add the shipping address
	
		address=new Address();
		address.setAddressLineOne("31/487,Ramnagar1,Dharmavaram1");
		address.setAddressLineTwo("Near Water Tank1");
		address.setCity("Dharmavaram1");
		address.setState("Andhra Pradesh1");
		address.setCountry("India1");
		address.setPostalCode("56006721");
		//set shipping true
		address.setShipping(true);
		//link it with the user
		address.setUser(user);
		assertEquals("Unable to add the Shipping Address..Something Went Wrong!",true,userDao.addAddress(address));
	}*/
	/*@Test
	public void testAddAddress()
	{
		user=userDao.getByEmail("Naresh@gmail.com");
		address=new Address();
		address.setAddressLineOne("35/487,Ramnagar2,Dharmavaram2");
		address.setAddressLineTwo("Near Water Tank2");
		address.setCity("Dharmavaram2");
		address.setState("Andhra Pradesh2");
		address.setCountry("India2");
		address.setPostalCode("56006722");
		//set shipping true
		address.setShipping(true);
		//link it with the user
		address.setUser(user);
		assertEquals("Unable to add the Shipping Address..Something Went Wrong!",true,userDao.addAddress(address));
	}*/
	
	@Test
	public void testGetAddress()
	{
		user=userDao.getByEmail("Naresh@gmail.com");
		
		//getting shipping address
		assertEquals("Unable to get the Shipping Address..Something Went Wrong!",2,userDao
				.listShippingAddress(user).size());
		
		//getting shipping address
				assertEquals("Unable to get the Shipping Address..Something Went Wrong!","Dharmavaram",userDao
						.getBillingAddress(user).getCity());
	}
	}
