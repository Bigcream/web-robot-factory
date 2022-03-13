package com.blog.controller.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.converter.OrderConverter;
import com.blog.dto.ProductDTO;
import com.blog.service.IOrderDetailService;
import com.blog.service.IOrderService;
import com.blog.service.IProductService;
import com.blog.service.IUserService;
import com.blog.util.SessionUtill;

@Controller(value = "productControllerOfWeb")
public class ProductController {
	@Autowired
	private IProductService productService;

	@Autowired
	private SessionUtill sessionUtill;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private OrderConverter orderConverter;
	

	@RequestMapping(value = "/Shop", method = RequestMethod.GET)
	public ModelAndView shopPage(@RequestParam(value = "page", required = false) int page, HttpSession session) {
		
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		
		//lấy lại page cũ
		SessionUtill.getInstance().putValue(session, "page", model.getPage());
		model.setLimit(6);
		ModelAndView mav = new ModelAndView("web/shop/shop");
		Pageable pageable = new PageRequest(page - 1, 6);
		model.setListResult(productService.findAll(pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/Space-robot", method = RequestMethod.GET)
	public ModelAndView spacerobotPage(@RequestParam(value = "page", required = false) int page, HttpSession session) {
		
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		SessionUtill.getInstance().putValue(session, "page", model.getPage());
		model.setLimit(6);
		ModelAndView mav = new ModelAndView("web/category/space-robot");
		Pageable pageable = new PageRequest(page - 1, 6);
		model.setListResult(productService.findAll(pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/Sport-robot", method = RequestMethod.GET)
	public ModelAndView sportrobotPage(@RequestParam(value = "page", required = false) int page, HttpSession session) {
		
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		SessionUtill.getInstance().putValue(session, "page", model.getPage());
		model.setLimit(6);
		ModelAndView mav = new ModelAndView("web/category/sport-robot");
		Pageable pageable = new PageRequest(page - 1, 6);
		model.setListResult(productService.findAll(pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/Toy-for-kid", method = RequestMethod.GET)
	public ModelAndView kidrobotPage(@RequestParam(value = "page", required = false) int page, HttpSession session) {
		
		ProductDTO model = new ProductDTO();
		model.setPage(page);
		SessionUtill.getInstance().putValue(session, "page", model.getPage());
		model.setLimit(6);
		ModelAndView mav = new ModelAndView("web/category/toy-for-kid");
		Pageable pageable = new PageRequest(page - 1, 6);
		model.setListResult(productService.findAll(pageable));
		model.setTotalItem(productService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
	
	@RequestMapping(value = "/Product-detail/{id}", method = RequestMethod.GET)
	public ModelAndView deailPage(@PathVariable Long id) {
		ProductDTO model = new ProductDTO();
		if (id != null) {
			// lấy product theo id nhận đc
			model = productService.findById(id);
		}
		ModelAndView mav = new ModelAndView("web/shop/product-detail");
		model.setListResult(productService.getItemRandom());
		mav.addObject("model", model);
		return mav;
	}

	
}
