package com.blog.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.blog.converter.AddressConverter;

import com.blog.dto.AddressDTO;
import com.blog.dto.MyUser;
import com.blog.dto.ProductDTO;
import com.blog.entity.AddressEntity;
import com.blog.entity.CategoryEntity;
import com.blog.entity.ProductEntity;
import com.blog.entity.UserEntity;
import com.blog.repository.AddressRepository;
import com.blog.repository.UserRepository;
import com.blog.service.IAddressService;
@Service
public class AddressService implements IAddressService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressConverter addressConverter;
	

	@Override
	public AddressDTO save(AddressDTO dto) {
		MyUser myUser = (MyUser) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
		UserEntity userEntity = userRepository.findByUserName(myUser.getUsername());
		AddressEntity addressEntity = new AddressEntity();
		AddressDTO addressDTO = new AddressDTO();

		addressEntity = addressConverter.toEntity(dto);
		
		addressEntity.setUser(userEntity);
		addressEntity = addressRepository.save(addressEntity);
		userEntity.setAddress(addressEntity);
		userRepository.save(userEntity);
		addressDTO = addressConverter.toDto(addressEntity);

		return addressDTO;
	}
	
}
