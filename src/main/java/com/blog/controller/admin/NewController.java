package com.blog.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.NewDTO;
import com.blog.entity.NewEntity;

import com.blog.service.ICategoryService;
import com.blog.service.INewService;
import com.blog.service.impl.CategoryService;
import com.blog.util.MessageUtil;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	@Autowired
	private INewService newService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "Admin/new/list", method = RequestMethod.GET)
	public ModelAndView showList() {
		NewDTO model = new NewDTO();
		ModelAndView mav = new ModelAndView("admin/new/list");
		model.setListResult(newService.findAll());
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "Admin/new/edit", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id,HttpServletRequest request) {
		NewDTO model = new NewDTO();
		ModelAndView mav = new ModelAndView("admin/new/edit");
		if (id != null) {
			model = newService.findById(id);
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
