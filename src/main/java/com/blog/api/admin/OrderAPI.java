package com.blog.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.OrderDTO;
import com.blog.dto.OrderDetailDTO;
import com.blog.service.IOrderDetailService;
import com.blog.service.IOrderService;



@RestController(value = "orderAPIOfAdmin")
public class OrderAPI {
	
	@Autowired
	private IOrderService orderService;
	
	@PutMapping("/api/order")
	public void updateStatusOrder(@RequestBody OrderDTO orderDTO) {

		orderService.save(orderDTO);
	}
}
