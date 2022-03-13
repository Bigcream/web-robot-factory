package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.RoleEntity;
import com.blog.repository.RoleRepository;
import com.blog.service.IRoleService;
@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	public RoleService() {
		
	}
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public RoleEntity findRoleByName(String roleName) {
		
		return roleRepository.findRoleByName(roleName);
	}

	@Override
	public Iterable<RoleEntity> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public void save(RoleEntity roleEntity) {
		// TODO Auto-generated method stub
		roleRepository.save(roleEntity);
	}

}
