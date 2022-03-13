package com.blog.entity;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {
	
	@Column(name = "name")
    private String name;
    
    @Column(name = "price")
    private float price;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "quantity")
    private long quantity;
    
    @Column(name = "status")
    private long status;
    
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private Blob image;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryP;
    
	@OneToMany(mappedBy = "product")
	private List<OrderDetailEntity> orderDetail = new ArrayList<>();
	
	
    
	public List<OrderDetailEntity> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetailEntity> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public CategoryEntity getCategoryP() {
		return categoryP;
	}
	public void setCategoryP(CategoryEntity categoryP) {
		this.categoryP = categoryP;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}


}
