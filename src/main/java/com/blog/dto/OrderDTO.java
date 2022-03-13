package com.blog.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO extends AbstractDTO<OrderDTO> {
	
	private Long id;
	
	private float totalPrice;
	
	private Long userId;
	
	private Long statusId;
	
	private String status;
	
	List<OrderDetailDTO> orderDetailDTO = new ArrayList<OrderDetailDTO>();
	
	
	
	public List<OrderDetailDTO> getOrderDetailDTO() {
		return orderDetailDTO;
	}

	public void setOrderDetailDTO(List<OrderDetailDTO> orderDetailDTO) {
		this.orderDetailDTO = orderDetailDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
