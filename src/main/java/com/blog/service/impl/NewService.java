package com.blog.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.blog.converter.NewConverter;
import com.blog.dto.NewDTO;
import com.blog.entity.CategoryEntity;
import com.blog.entity.NewEntity;

import com.blog.repository.CategoryRepository;
import com.blog.repository.NewRepository;
import com.blog.service.INewService;
@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = (newRepository.findAll());
		for (NewEntity item: entities) {
			NewDTO newDTO = new NewDTO();
			try {
				newDTO = newConverter.toDto(item);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity newEntity = newRepository.findOne(id);
		NewDTO newDTO = new NewDTO();
		try {
			newDTO =  newConverter.toDto(newEntity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDTO;
	}

	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		NewDTO newDTO = new NewDTO();
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());
			oldNew.setCategory(category);
			try {
				newEntity = newConverter.toEntity(oldNew, dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				newEntity = newConverter.toEntity(dto);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newEntity.setCategory(category);
		}
		try {
			newDTO = newConverter.toDto(newRepository.save(newEntity));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDTO;
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			newRepository.delete(id);
		}
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		NewDTO newDTO = new NewDTO();
		for (NewEntity item: entities) {
			try {
				newDTO = newConverter.toDto(item);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			models.add(newDTO);
		}
		return models;
	}
}