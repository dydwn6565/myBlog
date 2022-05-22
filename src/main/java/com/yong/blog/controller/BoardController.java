package com.yong.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yong.blog.service.MystoryService;

@Controller
public class BoardController {
	
	@Autowired
	private MystoryService mystoryservice;
	
	
	@GetMapping("/myIdea")
	public String myIdea() {
		return "myIdea";
	}

	@GetMapping("/myprofile")
	public String myprofile() {
		return "myprofile";
	}
	
	@GetMapping("/community")
	public String community() {
		return "community";
	}
}
