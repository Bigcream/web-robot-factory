package com.blog.converter;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.dto.OrderDTO;
import com.blog.dto.OrderDetailDTO;
import com.blog.dto.ProductDTO;
import com.blog.entity.OrderDetailEntity;
import com.blog.entity.OrderEntity;
import com.blog.entity.ProductEntity;
import com.blog.util.ImageUtill;

@Component
public class OrderConverter {
	@Autowired
	private ImageUtill imageUtill;
	
	@Autowired
	private OrderDetailConverter orderDetailConverter;

	public OrderDTO toDto(OrderEntity entity) throws SQLException {
		OrderDTO result = new OrderDTO();
		List<OrderDetailDTO> orderDetailDTO = new ArrayList<OrderDetailDTO>();
		OrderDetailDTO order = new OrderDetailDTO();
		result.setId(entity.getId());
		for(OrderDetailEntity detailEntity : entity.getOrderDetail()) {
			order =  orderDetailConverter.toDto(detailEntity);
			orderDetailDTO.add(order);
		}
		result.setOrderDetailDTO(orderDetailDTO);
		result.setId(entity.getId());
		result.setTotalPrice(entity.getTotalPrice());
		result.setCreatedDate((Timestamp) entity.getCreatedDate());
		result.setCreatedBy(entity.getCreatedBy());
		result.setStatus(entity.getStatusOrder().getStatus());
		result.setStatusId(entity.getStatusOrder().getId());
		return result;
	}
}
