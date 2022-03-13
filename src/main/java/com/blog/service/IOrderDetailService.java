package com.blog.service;



import java.util.List;

import com.blog.dto.OrderDetailDTO;
import com.blog.entity.OrderEntity;


public interface IOrderDetailService {
	OrderDetailDTO findOne(Long id);
	List<OrderDetailDTO> findByOrderId(Long id);
}
