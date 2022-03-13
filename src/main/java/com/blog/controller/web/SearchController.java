package com.blog.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.ProductDTO;
import com.blog.service.IProductService;
import com.blog.util.SessionUtill;

@Controller(value = "searchControllerOfWeb")
public class SearchController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/Search", method = RequestMethod.POST)
	public ModelAndView kidrobotPage(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "key", required = false) String key) {
		
		ProductDTO model = new ProductDTO();
		
		// set thông số phân trang
		model.setPage(page);
		model.setLimit(6);
		ModelAndView mav = new ModelAndView("web/shop/search/search-product");
		
		// lấy tất cả product dựa theo key
		model.setListResult(productService.findAllProduct(key, (page-1)));
		model.setTotalItem(productService.getTotalSearch(key));
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
}
