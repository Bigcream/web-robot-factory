package com.blog.service;

import java.util.List;
import java.util.Map;

import com.blog.entity.StatusEntity;

public interface IStatusService {
	List<StatusEntity> findAll();
	Map<Long, String> findAllStatus();
	StatusEntity findOne(Long id);
}
