package com.ss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title", "Home");
		model.addObject("userClickHome",true);
		return model;
		
	}

@RequestMapping(value="/about")
public ModelAndView about()
{
	ModelAndView model=new ModelAndView("page");
	model.addObject("title", "About Us");
	model.addObject("userClickAbout",true);
	return model;
	
}
@RequestMapping(value="/contact")
public ModelAndView contact()
{
	ModelAndView model=new ModelAndView("page");
	model.addObject("title", "contact");
	model.addObject("userClickContact",true);
	return model;
	
}

}
