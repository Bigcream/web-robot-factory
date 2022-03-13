package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.blog.entity.StatusEntity;
@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

}
