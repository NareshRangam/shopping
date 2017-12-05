package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ss.dao.CategoryDAO;
import com.ss.dto.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDao;
	
	
@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title", "Home");
		//passing the list of categories
		model.addObject("categories", categoryDao.list());
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
	model.addObject("title", "Contact Us");
	model.addObject("userClickContact",true);
	return model;
	
}

/*method to all products based on category*/

@RequestMapping(value="/show/all/products")
public ModelAndView showAllProducts()
{
	ModelAndView model=new ModelAndView("page");
	model.addObject("title", "All Products");
	//passing the list of categories
	model.addObject("categories", categoryDao.list());
	model.addObject("userClickAllProducts",true);
	return model;
	
}

/*method to get single product based on category id*/

@RequestMapping(value="/show/category/{id}/products")
public ModelAndView showCategoryProducts(@PathVariable("id") int id)
{
	ModelAndView model=new ModelAndView("page");
	
	/*categoryDAO to fetch a single category*/
	Category category=null;
	category=categoryDao.get(id);
	model.addObject("title", category.getName());
	//passing the list of categories
	model.addObject("categories", categoryDao.list());
	//passing the single category
		model.addObject("category",category );
	model.addObject("userClickCategoryProducts",true);
	return model;
	
}







}
