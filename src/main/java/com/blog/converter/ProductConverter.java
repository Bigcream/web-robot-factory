package com.blog.converter;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.dto.ProductDTO;
import com.blog.entity.ProductEntity;
import com.blog.util.ImageUtill;

@Component
public class ProductConverter {
	@Autowired
	private ImageUtill imageUtill;

	public ProductDTO toDto(ProductEntity entity) throws SQLException {
		ProductDTO result = new ProductDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setDescription(entity.getDescription());
		result.setPrice(entity.getPrice());
		result.setStatus(entity.getStatus());
		result.setQuantity(entity.getQuantity());
		result.setImage(imageUtill.convertBlobToImage(entity.getImage()));
		result.setCategoryCode(entity.getCategoryP().getCode());
		result.setCategoryId(entity.getCategoryP().getId());
		return result;
	}
	
	public ProductEntity toEntity(ProductDTO dto) throws SQLException {
		ProductEntity result = new ProductEntity();
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		result.setPrice(dto.getPrice());
		result.setStatus(1l);
		result.setQuantity(dto.getQuantity());
		result.setImage(imageUtill.convertImagetoBlob(dto.getImage()));
		return result;
	}
	
	public ProductEntity toEntity(ProductEntity result, ProductDTO dto) throws SQLException {
		result.setName(dto.getName());
		result.setDescription(dto.getDescription());
		result.setPrice(dto.getPrice());
		result.setStatus(1l);
		result.setQuantity(dto.getQuantity());
		result.setImage(imageUtill.convertImagetoBlob(dto.getImage()));
		return result;
	}
}
