package com.ss.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ss.dao.CategoryDAO;
import com.ss.dao.ProductDAO;
import com.ss.dto.Category;
import com.ss.dto.Product;
import com.ss.util.FileUploadUtility;
import com.ss.validator.ProductValidator;

@Controller
@RequestMapping("/manage")
public class ManageController {
	@Autowired
	private CategoryDAO categoryDao;
	
	@Autowired
	private ProductDAO productDao;
	private static final Logger logger=LoggerFactory.getLogger(ManageController.class);
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false )String operation)
	{
		ModelAndView model=new ModelAndView("page");
		model.addObject("userClickManageProducts",true);
		model.addObject("title", "Manage Products");
		
		Product nProduct=new Product();
		nProduct.setActive(true);
		nProduct.setSupplierId(1);
		
		model.addObject("product",nProduct);
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				model.addObject("message","Product Submitted Successfully");
			}
			else if(operation.equals("category"))
			{
				model.addObject("message","Category Submitted Successfully");
			}
		}
		return model;
		
	}
	
	/*submission of new product*/
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String productsSubmissioin(@Valid @ModelAttribute("product")Product mProduct,BindingResult results,Model model,HttpServletRequest request )
	{
		//custom validator...image validation
		if(mProduct.getId()==0){
		new ProductValidator().validate(mProduct, results);
		}
		else
		{
			if(!mProduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidator().validate(mProduct, results);
			}
		}
		//checking for Errors
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation fails for Product Submission");
			return "page";
		}
		logger.info(mProduct.toString());
		
		if(mProduct.getId()==0)
		{
			//adding product if id=0
			productDao.add(mProduct);
		}
		else
		{
			//updating product if id!=0
			productDao.update(mProduct);
		}
		//file checking Empty or not
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	
		//updating the product
		
		@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
		public ModelAndView productUpdation(@PathVariable int id)
		{
			
			ModelAndView model=new ModelAndView("page");
			model.addObject("userClickManageProducts",true);
			model.addObject("title", "Manage Products");
			//getting the product from database
			Product nProduct=productDao.get(id);
		
			model.addObject("product",nProduct);
						return model;
		
	}
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{
		//getting product using id
		Product product=productDao.get(id);
		boolean isActive=product.isActive();
		//activating and de-activating the isActive field
		product.setActive(!product.isActive());
		//updating the product
		productDao.update(product);
		return (isActive)?"You have successfully de-activated the product "+product.getId():
						  "You have successfully activated the product "+product.getId();
	}
	//category submissin
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category)
	{
		categoryDao.add(category);
		return "redirect:/manage/products?operation=category";
		
	}
	
	
	
	
	
	/*Returning All Categories*/
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.list();
	}
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}

}
