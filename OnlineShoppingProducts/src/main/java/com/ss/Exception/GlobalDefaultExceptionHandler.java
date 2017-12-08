package com.ss.Exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView model=new ModelAndView("error");
		model.addObject("errorTitle","The Page Is Not Constructed");
		model.addObject("errorDescription", "The page your looking is not available");
		model.addObject("title", "404 Error Page");
		return model;
		
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView model=new ModelAndView("error");
		model.addObject("errorTitle","Product Not Available");
		model.addObject("errorDescription", "The Product your looking is not available right Now");
		model.addObject("title", "Product Not Available");
		return model;
		
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView model=new ModelAndView("error");
		model.addObject("errorTitle","Contact Your Administator");
		
		/*debugging Application*/
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		model.addObject("errorDescription", sw.toString());
		model.addObject("title", "Error");
		return model;
		
	}
}
