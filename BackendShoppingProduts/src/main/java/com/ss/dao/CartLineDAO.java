package com.ss.dao;
import java.util.*;

import com.ss.dto.Cart;
import com.ss.dto.CartLine;

public interface CartLineDAO {
	
	//common methods
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);

	
	//bussiness methods
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);

	boolean updateCart(Cart cart);
}
