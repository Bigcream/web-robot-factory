package com.blog.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.CategoryEntity;
import com.blog.entity.StatusEntity;
import com.blog.repository.StatusRepository;
import com.blog.service.IStatusService;

@Service
public class StatusService implements IStatusService {
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<StatusEntity> findAll() {
		return statusRepository.findAll();
	}

	@Override
	public Map<Long, String> findAllStatus() {
		Map<Long, String> result = new HashMap<>();
		List<StatusEntity> entities = statusRepository.findAll();
		for (StatusEntity item: entities) {
			result.put(item.getId(), item.getStatus());
		}
		return result;
	}

	@Override
	public StatusEntity findOne(Long id) {
		
		return statusRepository.findOne(id);
	}

}
