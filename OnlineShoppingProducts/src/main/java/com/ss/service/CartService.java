package com.ss.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.CartLineDAO;
import com.ss.dao.ProductDAO;
import com.ss.dto.Cart;
import com.ss.dto.CartLine;
import com.ss.dto.Product;
import com.ss.model.UserModel;

@Service("cartService")
public class CartService {
	@Autowired
	private CartLineDAO cartLineDao;
	@Autowired
	private ProductDAO productDao;
	@Autowired
	private HttpSession session;
	//returns the cart who has logged in
	private Cart getCart()
	{
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	public List<CartLine> getCartLines()
	{
		return cartLineDao.list(this.getCart().getId());
	}
	public String updateCartLine(int cartLineId, int count) {
		
		//fetch the cartLine
		CartLine cartLine=cartLineDao.get(cartLineId);
		if(cartLine==null)
		{
			return "result=error";
		}
		else
		{
			Product product=cartLine.getProduct();
			double oldTotal=cartLine.getTotal();
			if(product.getQuantity()<=count)
			{
				count=product.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice()*count);
			
			cartLineDao.update(cartLine);
			Cart cart=this.getCart();
			cart.setGrandTotal(cart.getGrandTotal()-oldTotal+cartLine.getTotal());
			cartLineDao.updateCart(cart);
			return "result=updated";
		}
	}
	public String deleteCartLine(int cartLineId) {
		
		//fetch the cartline
		CartLine cartLine=cartLineDao.get(cartLineId);
		if(cartLine==null)
		{
			return "result=error";
		}
		else
		{
			//update the cart
			Cart cart=this.getCart();
			cart.setGrandTotal(cart.getGrandTotal()-cartLine.getTotal());
			cart.setCartLines(cart.getCartLines()-1);
			cartLineDao.updateCart(cart);
			//remove the cartline
			cartLineDao.delete(cartLine);
			return "result=deleted";
		}
	}
	public String addCartLine(int productId) {
		
		String response=null;
		Cart cart=this.getCart();
		CartLine cartLine=cartLineDao.getByCartAndProduct(cart.getId(), productId);
		if(cartLine==null){
			//add new cartline
			cartLine=new CartLine();
			//fetch the product
			Product product=productDao.get(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineDao.add(cartLine);
			
			cart.setCartLines(cart.getCartLines()+1);
			cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
			cartLineDao.updateCart(cart);
			response="result=added";
		}
		else
		{
			/*check if the cartLine has been already reached to maximum count*/
			if(cartLine.getProductCount() <= 5) {
				// call the updateCartLine method to increase the count
				response = this.updateCartLine(cartLine.getId(), cartLine.getProductCount() + 1);				
			}
			else
			{
				response = "result=maximum";		
			}
		}
		return response;
	}
}

















