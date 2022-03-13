package com.blog.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderproduct")
public class OrderEntity extends BaseEntity  {
	


	
	@Column(name = "totalprice")
	private float totalPrice;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
    
	@OneToMany(mappedBy = "order")
	private List<OrderDetailEntity> orderDetail = new ArrayList<>();
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private StatusEntity statusOrder;
    
    
	public StatusEntity getStatusOrder() {
		return statusOrder;
	}

	public void setStatusOrder(StatusEntity statusOrder) {
		this.statusOrder = statusOrder;
	}

	public List<OrderDetailEntity> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetailEntity> orderDetail) {
		this.orderDetail = orderDetail;
	}




	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
    
}
