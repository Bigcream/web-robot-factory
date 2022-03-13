package com.blog.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.converter.OrderDetailConverter;
import com.blog.dto.OrderDetailDTO;
import com.blog.entity.OrderDetailEntity;
import com.blog.repository.OrderDetailRepository;
import com.blog.repository.StatusRepository;
import com.blog.service.IOrderDetailService;

@Service
public class OrderDetailService implements IOrderDetailService {
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private OrderDetailConverter orderDetailConverter;
	


	@Override
	public OrderDetailDTO findOne(Long id) {
		OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
		try {
			orderDetailDTO = orderDetailConverter.toDto(orderDetailRepository.findOne(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDetailDTO;
	}



	@Override
	public List<OrderDetailDTO> findByOrderId(Long id) {
		List<OrderDetailDTO> orderDetailDTO = new ArrayList<OrderDetailDTO>();
		
		List<OrderDetailEntity> orderDetailEntity = orderDetailRepository.findByOrderId(id);
		for (OrderDetailEntity entity : orderDetailEntity) {
			try {
				orderDetailDTO.add(orderDetailConverter.toDto(entity));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return orderDetailDTO ;
	}





}
