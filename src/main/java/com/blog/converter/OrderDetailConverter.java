package com.blog.converter;

import java.sql.SQLException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.blog.dto.ItemDTO;
import com.blog.dto.OrderDTO;
import com.blog.dto.OrderDetailDTO;
import com.blog.entity.OrderDetailEntity;
import com.blog.entity.OrderEntity;
import com.blog.util.ImageUtill;

@Component
public class OrderDetailConverter {
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ImageUtill imageUtill;
	
	public OrderDetailEntity toEntity(ItemDTO itemDTO) throws SQLException {
		OrderDetailEntity result = new OrderDetailEntity();
    		result.setProductName(itemDTO.getProductDTO().getName());
    		result.setProductPrice(itemDTO.getProductDTO().getPrice());
    		result.setProductQuantity(itemDTO.getQuantity());

		return result;
	}
	
	
	public OrderDetailDTO toDto(OrderDetailEntity entity ) throws SQLException {
		OrderDetailDTO result = new OrderDetailDTO();
		result.setId(entity.getId());
		result.setProductName(entity.getProductName());
		result.setProductQuantity(entity.getProductQuantity());
		result.setProductPrice(entity.getProductPrice());
		result.setProductImage(imageUtill.convertBlobToImage(entity.getProduct().getImage()));
		result.setProductId(entity.getProduct().getId());
		result.setOrderId(entity.getOrder().getId());
		return result;
	}
	
}
