package com.blog.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dto.AddressDTO;
import com.blog.dto.OrderDetailDTO;
import com.blog.service.IOrderDetailService;
import com.blog.service.IUserService;

@Controller(value = "orderControllerOfWeb")
public class OrderController {
	

	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/Order/Detail/{id}", method = RequestMethod.GET)
	public ModelAndView myOrderPage(@PathVariable Long id) {
		AddressDTO addressDTO = userService.findAddress(id);
		//lấy ra order detail
		List<OrderDetailDTO> orderDetailDTO = orderDetailService.findByOrderId(id);
		ModelAndView mav = new ModelAndView("web/order/order-detail");
		mav.addObject("orderDetailDTO", orderDetailDTO);
		mav.addObject("addressDTO", addressDTO);
		return mav;
	}
}
