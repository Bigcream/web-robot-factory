package com.blog.converter;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.dto.NewDTO;
import com.blog.entity.NewEntity;
import com.blog.util.ImageUtill;



@Component
public class NewConverter {
	@Autowired
	private ImageUtill imageUtill;

	public NewDTO toDto(NewEntity entity) throws SQLException {
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setShortDescription(entity.getShortDescription());
		result.setContent(entity.getContent());
		result.setThumbnail(imageUtill.convertBlobToThumbnail(entity));
		result.setCategoryCode(entity.getCategory().getCode());
		result.setCreatedBy(entity.getCreatedBy());
		result.setCreatedDate((Timestamp) entity.getCreatedDate());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) throws SQLException {
		NewEntity result = new NewEntity();
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail_Blob(imageUtill.convertThumbnailtoBlob(dto));
		return result;
	}
	
	public NewEntity toEntity(NewEntity result, NewDTO dto) throws SQLException {
		result.setTitle(dto.getTitle());
		result.setShortDescription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail_Blob(imageUtill.convertThumbnailtoBlob(dto));
		return result;
	}
}
