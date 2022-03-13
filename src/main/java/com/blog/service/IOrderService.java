package com.blog.service;

import java.util.List;

import com.blog.dto.CartDTO;
import com.blog.dto.OrderDTO;
import com.blog.entity.OrderDetailEntity;
import com.blog.entity.OrderEntity;
import com.blog.entity.UserEntity;

public interface IOrderService {
	OrderDetailEntity save(UserEntity userEntity , CartDTO cartDTO);
	List<OrderEntity> findByUserId(Long id);
	List<OrderEntity> findAll();
	OrderDTO findOne(Long id);
	void save(OrderDTO orderDTO);
}
