package com.blog.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blog.converter.ProductConverter;
import com.blog.dto.NewDTO;
import com.blog.dto.ProductDTO;
import com.blog.entity.CategoryEntity;
import com.blog.entity.NewEntity;
import com.blog.entity.ProductEntity;
import com.blog.repository.CategoryRepository;
import com.blog.repository.ProductRepository;
import com.blog.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = (productRepository.findAll());
		for (ProductEntity item: entities) {
			ProductDTO productDTO = new ProductDTO();
			try {
				productDTO = productConverter.toDto(item);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			models.add(productDTO);
		}
		return models;
	}
	@Override
	public ProductDTO findById(long id) {
		ProductEntity productEntity = productRepository.findOne(id);
		ProductDTO productDTO = new ProductDTO();
		try {
			productDTO =  productConverter.toDto(productEntity);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productDTO;
	}
	@Override
	public ProductDTO save(ProductDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		ProductEntity productEntity = new ProductEntity();
		ProductDTO productDTO = new ProductDTO();
		
		//kiểm tra id nếu không null là update ngược lại là create
		if (dto.getId() != null) {
			
			// lấy ra product cũ set lại category
			ProductEntity oldNew = productRepository.findOne(dto.getId());
			oldNew.setCategoryP(category);
			try {
				productEntity = productConverter.toEntity(oldNew, dto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			try {
				productEntity = productConverter.toEntity(dto);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			productEntity.setCategoryP(category);
		}
		try {
			productDTO = productConverter.toDto(productRepository.save(productEntity));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return productDTO;
	}
	@Override
	public void delete(long[] ids) {
		for (long id: ids) {
			productRepository.delete(id);
		}
		
	}
	@Override
	public int getTotalItem() {
		return (int) productRepository.count();
	}
	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		ProductDTO productDTO = new ProductDTO();
		for (ProductEntity item: entities) {
			try {
				productDTO = productConverter.toDto(item);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			models.add(productDTO);
		}
		return models;
	}
	@Override
	public List<ProductDTO> findAllProduct(String keyWord, Integer offSet) {
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		List<ProductEntity> productEntity = (List<ProductEntity>) productRepository.findAllProduct(keyWord, offSet);
		for (ProductEntity entity : productEntity) {
			try {
				productDTO.add(productConverter.toDto(entity));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return productDTO ;
	}
	@Override
	public int getTotalSearch(String key) {
		List<ProductEntity> productEntity = (List<ProductEntity>) productRepository.getTotalSearch(key);
		return productEntity.size();
	}
	@Override
	public List<ProductDTO> getItemRandom() {
		List<ProductDTO> productDTO = new ArrayList<ProductDTO>();
		List<ProductEntity> productEntity = (List<ProductEntity>) productRepository.getItemRandom();
		for (ProductEntity entity : productEntity) {
			try {
				productDTO.add(productConverter.toDto(entity));
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return productDTO ;
	}
	

}
