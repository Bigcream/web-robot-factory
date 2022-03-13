package com.blog.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.blog.dto.ProductDTO;
import com.blog.service.IProductService;

@RestController(value = "productAPIOfAdmin")
public class ProductAPI {
	
	@Autowired
	private IProductService productService;
	@PostMapping("/api/product")
	public ProductDTO createNew(@RequestBody ProductDTO productDTO) {

		return productService.save(productDTO);
	}
	
	@PutMapping("/api/product")
	public ProductDTO updateNew(@RequestBody ProductDTO updateProduct) {

		return productService.save(updateProduct);
	}
	
	@DeleteMapping("/api/product")
	public void deleteNew(@RequestBody long[] ids) {
		productService.delete(ids);
	}
}
