package com.ss.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ss.dao.UserDAO;
import com.ss.dto.Address;
import com.ss.dto.Cart;
import com.ss.dto.User;
import com.ss.model.RegisterModel;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	public void addBilling(RegisterModel registerModel,Address billing)
	{
		registerModel.setBilling(billing);
	}
	public String validateUser(User user,MessageContext error)
	{
		String transitionValue="success";
		//checking confirm password
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("password does not match with confirm password").build());
			transitionValue="failure";
		}
		//checking unique mail
		if(userDao.getByEmail(user.getEmail())!=null)
		{
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email already exist").build());
			transitionValue="failure";
		}
		return transitionValue;
	}
	public String saveAll(RegisterModel registerModel)
	{
		String transitionValue="success";
		
		/*fetching user details*/
		
		User user=registerModel.getUser();
		if(user.getRole().equals("USER"))
		{
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//encrypt the password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
	/*	saving user details*/
		
		userDao.addUser(user);
		/*get the address*/
		Address billing=registerModel.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		/*save address*/
		userDao.addAddress(billing);
		return transitionValue;
	}
}
