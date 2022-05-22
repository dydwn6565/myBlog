package com.yong.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yong.blog.model.MyPhoto;

@Repository
public interface MyphotoRepository extends JpaRepository<MyPhoto,Integer> {
	
	
}
