package com.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/cart")
public class CartController {
	@RequestMapping("/show")
	public ModelAndView showCart()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title","user Cart");
		model.addObject("userClickShowCart",true);
		model.addObject("cartLines",null);
		return model;
	}

}
