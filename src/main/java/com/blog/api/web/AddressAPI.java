package com.blog.api.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.AddressDTO;
import com.blog.service.IAddressService;


@RestController(value = "addressAPIOfHome")
public class AddressAPI {
	
	@Autowired
	private IAddressService addressService;
	
	@PostMapping("/api/address")
	public AddressDTO cartPage(@RequestBody AddressDTO addressDTO) {
		
		return addressService.save(addressDTO);
		
	}
}
