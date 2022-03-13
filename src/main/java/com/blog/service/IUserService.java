package com.blog.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.blog.dto.AddressDTO;
import com.blog.entity.AddressEntity;
import com.blog.entity.UserEntity;

public interface IUserService extends UserDetailsService {
	UserEntity findById(Long id);
	Iterable<UserEntity> findAll();
	UserEntity findByUserName(String userName);
	AddressDTO findAddress(Long id);
}
