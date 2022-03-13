package com.blog.controller.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.converter.OrderConverter;
import com.blog.converter.StatusConverter;
import com.blog.dto.AddressDTO;
import com.blog.dto.CartDTO;
import com.blog.dto.MyUser;
import com.blog.dto.OrderDTO;
import com.blog.dto.StatusDTO;
import com.blog.entity.AddressEntity;
import com.blog.entity.OrderDetailEntity;
import com.blog.entity.OrderEntity;
import com.blog.entity.StatusEntity;
import com.blog.entity.UserEntity;
import com.blog.service.IOrderService;
import com.blog.service.IStatusService;
import com.blog.service.IUserService;
import com.blog.util.MessageUtil;
import com.blog.util.SessionUtill;

@Controller(value = "checkOutControllerOfWeb")
public class CheckOutController {

	@Autowired
	private SessionUtill sessionUtill;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@RequestMapping(value = "/Check-out/Order", method = RequestMethod.GET)
	public ModelAndView myOrderPage() {
		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		
		//lấy ra order của user
		List<OrderEntity> orderEntity = orderService.findByUserId(myUser.getId());
		ModelAndView mav = new ModelAndView("web/order/checkout");
		List<OrderDTO> orderDTO = new ArrayList<OrderDTO>();
		
		//converter entity sang dto (lỗi nên conver ở service)
		for (OrderEntity order : orderEntity) {
			try {
				orderDTO.add(orderConverter.toDto(order));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		mav.addObject("orderDTO", orderDTO);
		return mav;
	}

	@RequestMapping(value = "/Check-out", method = RequestMethod.POST)
	public ModelAndView checkOutPage(@RequestParam(value = "codeSale", required = false) float codeSale,
			HttpSession session) {
		Object object = sessionUtill.getInstance().getValue(session, "cart");
		CartDTO cartDTO = null;
		if (object != null) {
			cartDTO = (CartDTO) object;
			
		} else {
			cartDTO = new CartDTO();
		}
		
		//lấy ra user hiện tại
		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		
		//lấy address của user
		AddressEntity address = myUser.getAddress();
		ModelAndView mav = null;
		
		//tạo address mới để mapping nếu chưa có
		AddressDTO addressDTO = new AddressDTO();
		
		//address null thì hiện thị thông báo
		if(address == null) {
			
			mav = new ModelAndView("web/order/cart");
			mav.addObject("message", "Add address pls!");
			mav.addObject("addressDTO", addressDTO);
			mav.addObject("alert", "danger");
		} else if (cartDTO.getItems().isEmpty()) {
			mav = new ModelAndView("redirect:/Cart"); //nếu giỏ hàng rỗng thì k lưu vào DB
			return mav;
		} else if(address != null && cartDTO.getItems() != null ) {
			
			//lấy ra user hiện tại
			UserEntity userEntity = userService.findById(myUser.getId());
			
			//set code giảm giá
			float oldTotalMoney = cartDTO.getTotalMoney();
			float newTotalMoney = (oldTotalMoney*(100-codeSale))/100;
			cartDTO.setNewTotalMoney(newTotalMoney);
			
			//lưu order và từng product vào DB
			OrderDetailEntity orderDetailEntity = orderService.save(userEntity, cartDTO);
			
			//xóa bỏ cart
			sessionUtill.getInstance().removeValue(session, "cart");
			mav = new ModelAndView("web/order/checkout");
			
			//lấy ra list order của user
			List<OrderEntity> orderEntity = orderService.findByUserId(myUser.getId());
			
			//converter to dto (lỗi cần conver trong service)
			List<OrderDTO> orderDTO = new ArrayList<OrderDTO>();
			for (OrderEntity order : orderEntity) {
				try {
					orderDTO.add(orderConverter.toDto(order));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			mav.addObject("orderDTO", orderDTO);
			mav.addObject("addressDTO", addressDTO);
			mav.addObject("orderDetailEntity", orderDetailEntity);
		}
		return mav;
	}
	
	// thay đổi trạng thái đơn hàng
	@RequestMapping(value = "/Change/{id}", method = RequestMethod.GET)
	public ModelAndView changeOrder(@PathVariable Long id) {
		
		// lấy ra order cần thay đổi
		OrderDTO orderDTO = orderService.findOne(id);
		
		// set trạng thái mới và lưu lại vào DB
		orderDTO.setStatusId(4l);
		orderService.save(orderDTO);
		ModelAndView mav = new ModelAndView("redirect:/Check-out");
		return mav;
	}
}
