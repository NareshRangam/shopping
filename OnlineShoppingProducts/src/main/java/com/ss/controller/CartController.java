package com.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ss.service.CartService;



@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name="result",required=false)String result)
	{
		ModelAndView model=new ModelAndView("page");
		if(result!=null)
		{
			switch(result)
			{
			case "updated":
				model.addObject("message", "CartLine Updated Successfully");
				break;
			case "deleted":
				model.addObject("message", "CartLine Deleted Successfully");
				break;
			case "added":
				model.addObject("message", "CartLine Added Successfully");
				break;
			case "maximum":
				model.addObject("message", "Maximum limit for the item has been reached!");
				break;
			case "error":
				model.addObject("message", "Something Went Wrong");
				break;
			
			}
			
		}
		model.addObject("title","User Cart");
		model.addObject("userClickShowCart",true);
		model.addObject("cartLines",cartService.getCartLines());
		return model;
	}
	
		/*	updating cart*/
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId,@RequestParam int count)
	{
		String response=cartService.updateCartLine(cartLineId,count);
		return "redirect:/cart/show?"+response;
	}

		/*	deleting cart*/
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId)
	{
		String response=cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	
		/*	adding cart*/
	@RequestMapping("/add/{productId}/product")
	public String addCart(@PathVariable int productId)
	{
		String response=cartService.addCartLine(productId);
		return "redirect:/cart/show?"+response;
	}
}
