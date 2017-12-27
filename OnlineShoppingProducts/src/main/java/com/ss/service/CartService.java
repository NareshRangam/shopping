package com.ss.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.dao.CartLineDAO;
import com.ss.dto.Cart;
import com.ss.dto.CartLine;
import com.ss.dto.Product;
import com.ss.model.UserModel;

@Service("cartService")
public class CartService {
	@Autowired
	private CartLineDAO cartLineDao;
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
}
