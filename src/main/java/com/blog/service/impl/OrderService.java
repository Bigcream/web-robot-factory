package com.blog.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.converter.OrderConverter;
import com.blog.converter.OrderDetailConverter;
import com.blog.converter.ProductConverter;
import com.blog.dto.CartDTO;
import com.blog.dto.ItemDTO;
import com.blog.dto.OrderDTO;
import com.blog.entity.OrderDetailEntity;
import com.blog.entity.OrderEntity;
import com.blog.entity.ProductEntity;
import com.blog.entity.StatusEntity;
import com.blog.entity.UserEntity;
import com.blog.repository.OrderDetailRepository;
import com.blog.repository.OrderRepository;
import com.blog.repository.ProductRepository;
import com.blog.repository.StatusRepository;
import com.blog.service.IOrderService;

@Service
public class OrderService implements IOrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private OrderDetailConverter orderDetailConverter;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderConverter orderConverter;

	@Override
	public OrderDetailEntity save(UserEntity userEntity, CartDTO cartDTO) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setTotalPrice(cartDTO.getNewTotalMoney());
		orderEntity.setUser(userEntity);
		
		//lấy status để lưu vào bảng order mặc định là đang chuẩn bị
		StatusEntity statusEntity = statusRepository.findOne(1l);
		orderEntity.setStatusOrder(statusEntity);
		
		//lưu order vào DB 
		orderEntity = orderRepository.save(orderEntity);
		
		OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
		
		//lưu chi tiết từng sản phẩm trong đơn hàng vào DB 
        for (ItemDTO item : cartDTO.getItems()) {
        	try {
				orderDetailEntity = orderDetailConverter.toEntity(item);
				ProductEntity productEntity = productRepository.findByName(item.getProductDTO().getName());
				productEntity.setQuantity(productEntity.getQuantity() - item.getQuantity());
				productRepository.save(productEntity);
				orderDetailEntity.setProduct(productEntity);
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	//set bảng order vào bảng orderDetail để lấy được id của bảng order
        	orderDetailEntity.setOrder(orderEntity);
        	orderDetailEntity = orderDetailRepository.save(orderDetailEntity);
        }
		return orderDetailEntity;
        
	}


	@Override
	public List<OrderEntity> findByUserId(Long id) {
		
		return orderRepository.findByUserId(id);
	}


	@Override
	public List<OrderEntity> findAll() {
		
		return orderRepository.findAll();
	}


	@Override
	public OrderDTO findOne(Long id) {
		OrderDTO orderDTO = new OrderDTO();
		try {
			// converter entity to DTO
			orderDTO = orderConverter.toDto(orderRepository.findOne(id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderDTO;
	}


	@Override
	public void save(OrderDTO orderDTO) {
		// api
		
		//lấy ra order by id
		OrderEntity orderEntity = orderRepository.findOne(orderDTO.getId());
		
		// lấy ra status by id (id gửi từ client xuống)
		StatusEntity statusEntity = statusRepository.findOne(orderDTO.getStatusId());
		
		//set status mới
		orderEntity.setStatusOrder(statusEntity);
		orderRepository.save(orderEntity);
		
	}






}
