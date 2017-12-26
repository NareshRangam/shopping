package com.ss.dao;

import java.util.List;

import com.ss.dto.Address;
import com.ss.dto.Cart;
import com.ss.dto.User;

public interface UserDAO {
	//Adding User
	boolean addUser(User user);
	//Adding Address
	boolean addAddress(Address address);
	//Adding Cart
	
	User getByEmail(String email); 
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);

}
