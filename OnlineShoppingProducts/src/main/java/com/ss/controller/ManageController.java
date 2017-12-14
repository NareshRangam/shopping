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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		}
		return model;
		
	}
	
	/*submission of new product*/
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String productsSubmissioin(@Valid @ModelAttribute("product")Product mProduct,BindingResult results,Model model,HttpServletRequest request )
	{
		//custom validator
		new ProductValidator().validate(mProduct, results);
		//checking for Errors
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation fails for Product Submission");
			return "page";
		}
		logger.info(mProduct.toString());
		productDao.add(mProduct);
		//file checking Empty or not
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
		
	}
	
	/*Returning All Categories*/
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.list();
	}

}
