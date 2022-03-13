package com.blog.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.constant.SystemConstant;
import com.blog.dto.MyUser;
import com.blog.entity.RoleEntity;
import com.blog.entity.UserEntity;
import com.blog.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), 
							true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		myUser.setId(userEntity.getId());
		if(userEntity.getAddress() != null) {
			myUser.setAddress(userEntity.getAddress());
		}
		

		return myUser;
	}

}
