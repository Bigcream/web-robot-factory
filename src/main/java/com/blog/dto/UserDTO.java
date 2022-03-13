package com.blog.dto;

import javax.persistence.Column;
import javax.persistence.Transient;

import com.blog.entity.UserEntity;

public class UserDTO extends AbstractDTO<UserEntity> {

	private String userName;


	private String password;


	private String fullName;
	

	private String email;
	

	private Long address_id;
	

	private Integer status;
	
	
	private String repeatPassword;
	
	private static UserDTO userDTO = null;
	
    public static UserDTO getInstance() {
        if (userDTO == null) {
        	userDTO = new UserDTO();
        }
        return userDTO;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getAddressId() {
		return address_id;
	}


	public void setAddressId(Long address_id) {
		this.address_id = address_id;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getRepeatPassword() {
		return repeatPassword;
	}


	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	
}
