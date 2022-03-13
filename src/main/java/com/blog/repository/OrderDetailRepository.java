package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.OrderDetailEntity;
import com.blog.entity.OrderEntity;
import com.blog.entity.UserEntity;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {
	List<OrderDetailEntity> findByOrderId(Long id);
}
