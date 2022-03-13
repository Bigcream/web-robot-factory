package com.blog.controller.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class AddressController {
	@RequestMapping(value = "/Add-address", method = RequestMethod.POST)
	public ModelAndView addressPage() {
		
		ModelAndView mav = new ModelAndView("web/shop/cart");

		return mav;
	}
}
