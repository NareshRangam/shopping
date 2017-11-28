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
		model.addObject("greeting", "Welcome to Spring MVC");
		return model;
		
	}
/*@RequestMapping(value="/test")
public ModelAndView test(@RequestParam(value="greeting",required=false)String greeting)
{
	if(greeting==null)
	{
		greeting="no text set";
	}
	ModelAndView model=new ModelAndView("page");
	model.addObject("greeting", greeting);
	return model;
	
}*/

@RequestMapping(value="/test/{greeting}")
public ModelAndView test(@PathVariable("greeting")String greeting)
{
	if(greeting==null)
	{
		greeting="no text set";
	}
	ModelAndView model=new ModelAndView("page");
	model.addObject("greeting", greeting);
	return model;
	
}

}
