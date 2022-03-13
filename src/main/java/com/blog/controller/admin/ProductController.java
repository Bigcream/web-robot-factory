package com.blog.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.NewDTO;
import com.blog.dto.ProductDTO;
import com.blog.service.ICategoryService;
import com.blog.service.IProductService;
import com.blog.service.impl.ProductService;
import com.blog.util.MessageUtil;

@Controller(value = "productControllerOfAdmin")
public class ProductController {
	
	@Autowired
	private MessageUtil messageUtil;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "Admin/product/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		ProductDTO model = new ProductDTO();
		ModelAndView mav = new ModelAndView("admin/product/list");
		model.setListResult(productService.findAll());
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "Admin/product/edit", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id,HttpServletRequest request) {
		ProductDTO model = new ProductDTO();
		ModelAndView mav = new ModelAndView("admin/product/edit");
		if (id != null) {
			model = productService.findById(id);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);
		return mav;
	}
}
