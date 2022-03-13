package com.blog.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.blog.dto.NewDTO;
import com.blog.dto.ProductDTO;
import com.blog.entity.ProductEntity;



public interface IProductService {
	int getTotalItem();
	List<ProductDTO> findAll(Pageable pageable);
	List<ProductDTO> findAll();
	ProductDTO findById(long id);
	ProductDTO save(ProductDTO dto);
	void delete(long[] ids);
	List<ProductDTO> findAllProduct(String keyWord, Integer offSet);
	int getTotalSearch(String key);
	List<ProductDTO> getItemRandom();
}
