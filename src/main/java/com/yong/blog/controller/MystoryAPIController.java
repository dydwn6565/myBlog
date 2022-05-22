package com.yong.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yong.blog.dto.ResponseDto;
import com.yong.blog.model.MyStory;
import com.yong.blog.service.MystoryService;

@RestController
public class MystoryAPIController {
	
	@Autowired
	MystoryService mystoryservice;
	
	@PostMapping("/api/mystory/write")
	public ResponseDto<Integer> writeMyStory(@RequestBody MyStory mystory) {
		
		mystoryservice.writeMystory(mystory);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/api/mystory/modify/{id}")
	public ResponseDto<Integer> modifyMyStory(@PathVariable int id, @RequestBody MyStory mystory){
		
		mystoryservice.modifyMystory(id, mystory);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@DeleteMapping("/api/mystory/delete/{id}")
	public ResponseDto<Integer> deleteMyStory(@PathVariable int id){
		mystoryservice.deleteMystory(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}
