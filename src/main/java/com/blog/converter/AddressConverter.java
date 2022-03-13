package com.blog.converter;

import org.springframework.stereotype.Component;

import com.blog.dto.AddressDTO;

import com.blog.entity.AddressEntity;

@Component
public class AddressConverter {
	public AddressDTO toDto(AddressEntity entity) {
		AddressDTO result = new AddressDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setPhoneNumber(entity.getPhoneNumber());
		result.setEmail(entity.getEmail());
		result.setAddress(entity.getAddress());
		result.setCity(entity.getCity());
		result.setCountry(entity.getCountry());
		result.setUserId(entity.getUser().getId());
		return result;
	}
	
	public AddressEntity toEntity(AddressDTO dto) {
		AddressEntity result = new AddressEntity();
		result.setName(dto.getName());
		result.setPhoneNumber(dto.getPhoneNumber());
		result.setEmail(dto.getEmail());
		result.setAddress(dto.getAddress());
		result.setCity(dto.getCity());
		result.setCountry(dto.getCountry());
		return result;
	}
}
