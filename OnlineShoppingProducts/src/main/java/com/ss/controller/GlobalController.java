package com.ss.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ss.dao.UserDAO;
import com.ss.dto.User;
import com.ss.model.UserModel;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	@Autowired
	private UserDAO userDao;
	private UserModel userModel;
	@ModelAttribute("userModel")
	public UserModel getUserModel()
	{
		if(session.getAttribute("userModel")==null)
		{
			//add user model
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
			User user=userDao.getByEmail(authentication.getName());
			if(user!=null)
			{
				// create a new userModel object to pass the user details
				userModel=new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" "+user.getLastName());
				
				if(userModel.getEmail().equals("USER"))
				{
					//set the cart if user is buyer 
					userModel.setCart(user.getCart());
				}
				// set the userModel into session
				session.setAttribute("userModel", userModel);
				return userModel;
			}
		}
		return (UserModel) session.getAttribute("userModel");
	}
}
