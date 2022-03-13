package com.blog.controller.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.NewDTO;
import org.springframework.data.domain.PageRequest;
import com.blog.repository.UserRepository;
import com.blog.service.ICategoryService;
import com.blog.service.INewService;

@Controller(value = "categoryControllerOfWeb")
public class NewsController {
	@Autowired
	private INewService newService;
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/News", method = RequestMethod.GET)
	public ModelAndView homePage(@RequestParam(value = "page", required = false) int page) {
		NewDTO model = new NewDTO();
		
		//set page để phân trang
		model.setPage(page);
		model.setLimit(6);
		ModelAndView mav = new ModelAndView("web/news/space robot/list");
		Pageable pageable = new PageRequest(page - 1, 6);
		
		//lấy ra list News
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
				return mav;
	}
	@RequestMapping(value = "/Detail", method = RequestMethod.GET)
	public ModelAndView detailPage(@RequestParam(value = "id", required = false) Long id) {
		NewDTO model = new NewDTO();
		ModelAndView mav = new ModelAndView("web/news/space robot/detail");
		if (id != null) {
			model = newService.findById(id);
		}
		
		mav.addObject("model", model);
		return mav;
	}
}
