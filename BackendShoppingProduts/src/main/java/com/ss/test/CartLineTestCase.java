package com.ss.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ss.dao.CartLineDAO;
import com.ss.dao.CategoryDAO;
import com.ss.dao.ProductDAO;
import com.ss.dao.UserDAO;
import com.ss.dto.Cart;
import com.ss.dto.CartLine;
import com.ss.dto.Product;
import com.ss.dto.User;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO cartLineDao=null;
	private static ProductDAO productDao=null;
	private static UserDAO userDao=null;
	
	private Product product=null;
	private User user=null;
	private Cart cart=null;
	private CartLine cartLine=null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ss");
		context.refresh();
		productDao=(ProductDAO) context.getBean("productDao");
		userDao = (UserDAO) context.getBean("userDao");
		cartLineDao=(CartLineDAO) context.getBean("cartLineDao");
	}
	@Test
	public void testAddNewCartLine()
	{
	//1.get the user
		user=userDao.getByEmail("user@gmail.com");
		//2.fetch the cart
		cart=user.getCart();
		//3.get the product
		product=productDao.get(1);
		//4.create new cartline
		cartLine=new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount()+1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		assertEquals("Unable to add CartLine!",true,cartLineDao.add(cartLine));
		//update cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("Unable to update CartLine!",true,cartLineDao.updateCart(cart));
		//assertEquals("Unable to list CartLine!",1,cartLineDao.list(1).size());
	}
	
}
