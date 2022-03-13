package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.RoleEntity;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findRoleByName(String roleName);
}
