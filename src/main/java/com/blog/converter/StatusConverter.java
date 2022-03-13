package com.blog.converter;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.blog.dto.StatusDTO;
import com.blog.entity.StatusEntity;
@Component
public class StatusConverter {
	public StatusDTO toDto(StatusEntity entity) throws SQLException {
		StatusDTO result = new StatusDTO();
		result.setId(entity.getId());
		result.setStatus(entity.getStatus());
		return result;
	}
}
