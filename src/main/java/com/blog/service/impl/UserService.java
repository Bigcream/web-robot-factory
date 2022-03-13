package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.controller.web.AddressController;
import com.blog.converter.AddressConverter;
import com.blog.dto.AddressDTO;
import com.blog.dto.UserPrinciple;
import com.blog.entity.AddressEntity;
import com.blog.entity.OrderEntity;
import com.blog.entity.UserEntity;
import com.blog.repository.AddressRepository;
import com.blog.repository.OrderRepository;
import com.blog.repository.UserRepository;
import com.blog.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressConverter addressConverter;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUserName(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		return UserPrinciple.build(userEntity);
	}

	@Override
	public Iterable<UserEntity> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public UserEntity findByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}

	@Override
	public UserEntity findById(Long id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public AddressDTO findAddress(Long id) {
		
		// lấy ra order by id
		OrderEntity orderEntity = orderRepository.findOne(id);
		
		//lấy user by id
		UserEntity userEntity = userRepository.findOne(orderEntity.getUser().getId());
		
		//lấy address by id
		AddressEntity addressEntity = addressRepository.findOne(userEntity.getAddress().getId());
		
		//converter sang dto
		AddressDTO addressDTO = addressConverter.toDto(addressEntity);
		return addressDTO;
	}
	
}
