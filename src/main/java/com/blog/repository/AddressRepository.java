package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.AddressEntity;
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
