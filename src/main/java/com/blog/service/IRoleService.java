package com.blog.service;

import com.blog.entity.RoleEntity;

public interface IRoleService {
	RoleEntity findRoleByName(String roleName);
	Iterable<RoleEntity> findAll();
	void save(RoleEntity roleEntity);
	
}
