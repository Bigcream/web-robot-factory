package com.blog.controller.admin;

import java.io.ObjectInputFilter.Status;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.converter.OrderConverter;
import com.blog.dto.AddressDTO;
import com.blog.dto.MyUser;
import com.blog.dto.OrderDTO;
import com.blog.dto.OrderDetailDTO;
import com.blog.dto.StatusDTO;
import com.blog.entity.OrderEntity;
import com.blog.entity.StatusEntity;
import com.blog.service.IOrderDetailService;
import com.blog.service.IOrderService;
import com.blog.service.IStatusService;
import com.blog.service.IUserService;
import com.blog.service.impl.StatusService;



@Controller(value = "orderControllerOfAdmin")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private OrderConverter orderConverter;
	
	@Autowired
	private IStatusService statusService;
	
	@Autowired
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "Admin/order/list", method = RequestMethod.GET)
	public ModelAndView showList() throws SQLException {
		
		//lấy danh sách order
		List<OrderEntity> orderEntity = orderService.findAll();
		ModelAndView mav = new ModelAndView("admin/order/list");
		List<OrderDTO> orderDTO = new ArrayList<OrderDTO>();
		
		// chuyển từ entity sang dto (lỗi phải chuyển ở service)
		for (OrderEntity order : orderEntity) {
			try {
				orderDTO.add(orderConverter.toDto(order));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// đẩy list order ra view
		mav.addObject("orderDTO", orderDTO);
		return mav;
	}
	@RequestMapping(value = "Admin/order/edit", method = RequestMethod.GET)
	public ModelAndView showEdit(@RequestParam(value = "id", required = false) Long id) throws SQLException {
		ModelAndView mav = new ModelAndView("admin/order/edit");
		
		// lấy order theo id
		OrderDTO orderDTO = orderService.findOne(id);
		
		//lấy địa chỉ của custumer
		AddressDTO addressDTO = userService.findAddress(orderDTO.getId());
		
		//đẩy ra view
		mav.addObject("orderDTO", orderDTO);
		mav.addObject("addressDTO", addressDTO);
		mav.addObject("statusEntity", statusService.findAllStatus());
		return mav;
	}
	
	// yes or no canceling
	@RequestMapping(value = "/Admin/order/canceling", method = RequestMethod.GET)
	public ModelAndView cancelingEdit(@RequestParam(value = "id", required = false) Long id, 
			@RequestParam(value = "statusId", required = false) Long statusId) throws SQLException {
		
		if (id != null && statusId != null) {
			// lấy ra order cần thay đổi
			OrderDTO orderDTO = orderService.findOne(id);
			
			// set trạng thái mới và lưu lại vào DB
			orderDTO.setStatusId(statusId);
			orderService.save(orderDTO);
		}
		
		//lấy danh sách order
		List<OrderEntity> orderEntity = orderService.findAll();
		List<OrderDTO> orderDTO = new ArrayList<OrderDTO>();
		
		// chuyển từ entity sang dto (lỗi phải chuyển ở service)
		for (OrderEntity order : orderEntity) {
			try {
				orderDTO.add(orderConverter.toDto(order));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// đẩy list order ra view
		ModelAndView mav = new ModelAndView("admin/order/cancel");;
		mav.addObject("orderDTO", orderDTO);
		return mav;
	}
	
	@RequestMapping(value = "/Admin/Order/Detail/{id}", method = RequestMethod.GET)
	public ModelAndView myOrderPage(@PathVariable Long id) {
		AddressDTO addressDTO = userService.findAddress(id);
		//lấy ra order detail
		List<OrderDetailDTO> orderDetailDTO = orderDetailService.findByOrderId(id);
		ModelAndView mav = new ModelAndView("admin/order/order-detail");
		mav.addObject("orderDetailDTO", orderDetailDTO);
		mav.addObject("addressDTO", addressDTO);
		return mav;
	}
}
