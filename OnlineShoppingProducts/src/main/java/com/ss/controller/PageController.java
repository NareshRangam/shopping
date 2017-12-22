package com.ss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ss.Exception.ProductNotFoundException;
import com.ss.dao.CategoryDAO;
import com.ss.dao.ProductDAO;
import com.ss.dto.Category;
import com.ss.dto.Product;

@Controller
public class PageController {
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private ProductDAO productDAO;
	
@RequestMapping(value={"/","/index","/home"})
	public ModelAndView index()
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("title", "Home");
		logger.info("Inside Page Controller index method-INFO");
		logger.debug("Inside Page Controller index method-debug");
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
public ModelAndView showingSingleProduct(@PathVariable("id") int id)
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

//viewing single product

@RequestMapping(value="/show/{id}/product")
public ModelAndView showCategoryProducts(@PathVariable("id") int id)throws ProductNotFoundException
{
	ModelAndView model=new ModelAndView("page");
	Product product=productDAO.get(id);
	if(product==null)throw new ProductNotFoundException();
	//update view count
	model.addObject("title",product.getName());
	model.addObject("product", product);
	model.addObject("userClickShowProduct", true);
return model;
}
/*login*/
@RequestMapping(value="/login")
public ModelAndView login(@RequestParam(name="error",required=false)String error,
		@RequestParam(name="logout",required=false)String logout)
{
	
	ModelAndView model=new ModelAndView("login");
	if(error!=null)
	{
		model.addObject("message","Invalid Username and Password");
	}
	if(logout!=null)
	{
		model.addObject("logout","User has successfully logged out");
	}
	model.addObject("title", "Login");
	return model;
	
}
//access denied
@RequestMapping(value="/access-denied")
public ModelAndView accessDenied()
{
	ModelAndView model=new ModelAndView("error");
	model.addObject("errorTitle","Restrictions");
	model.addObject("errorDescription", "Your are not Authorize to page your looking ");
	model.addObject("title", "403-Access Denied");
	return model;
	
}
//logout
@RequestMapping(value="/perform-logout")
public String logout(HttpServletRequest request,HttpServletResponse response)
{
	//fetch the authentication
	Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	if(auth!=null)
	{
		new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:login?logout";
	
}
}
