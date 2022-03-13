package com.blog.service;

import org.springframework.security.core.Authentication;

import com.blog.dto.AddressDTO;


public interface IAddressService {
	AddressDTO save(AddressDTO dto);
}
