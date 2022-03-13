package com.blog.repository;

import java.util.Collection;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity findByName(String name);

	@Query(value = "SELECT * FROM product WHERE MATCH (name, description) AGAINST (?1) Limit ?2,6", nativeQuery = true)
	Collection<ProductEntity> findAllProduct(String keyWord, Integer offSet);

	@Query(value = "SELECT * FROM product WHERE MATCH (name, description) AGAINST (?1) ", nativeQuery = true)
	Collection<ProductEntity> getTotalSearch(String key);
	
	@Query(value = "SELECT * FROM product ORDER BY RAND() LIMIT 4", nativeQuery = true)
	Collection<ProductEntity> getItemRandom();
}
