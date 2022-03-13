package com.blog.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	
	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	
	@Column
	private Integer status;
	
	@Transient
	private String repeatPassword;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), 
								  inverseJoinColumns = @JoinColumn(name = "roleid"))
	private Set<RoleEntity> roles = new HashSet<RoleEntity>();
	
	@OneToMany(mappedBy = "user")
	private List<OrderEntity> order = new ArrayList<>();
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    
    
    
	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public List<OrderEntity> getOrder() {
		return order;
	}

	public void setOrder(List<OrderEntity> order) {
		this.order = order;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}


}
