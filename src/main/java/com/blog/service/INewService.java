package com.blog.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.blog.dto.NewDTO;


public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	List<NewDTO> findAll();
	NewDTO findById(long id);
	NewDTO save(NewDTO dto);
	void delete(long[] ids);
	int getTotalItem();
}
