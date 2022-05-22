package com.yong.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yong.blog.model.MyStory;

@Repository
public interface MystoryRepository extends JpaRepository<MyStory,Integer> {
	

}
