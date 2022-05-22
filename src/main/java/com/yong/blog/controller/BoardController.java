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
	
	@GetMapping("/myphoto")
	public String myphoto() {
		return "myphoto";
	}
	
	@GetMapping("/mystory")
	public String mystory(Model model, @PageableDefault(size=3,sort="id",direction= Sort.Direction.DESC) Pageable pageable) {
		
		
		model.addAttribute("mystory",mystoryservice.readyMystory(pageable));
		System.out.println("mystory model"+model);
		return "mystory/mystory";
	}
	
	@GetMapping("/mystory/{id}")
	public String mystoryDetail(@PathVariable int id, Model model) {
		model.addAttribute("mystory",mystoryservice.readyOneMystory(id));
		return "mystory/detail";
	}
	
	@GetMapping("/mystory/{id}/modify")
	public String mystorymodify(@PathVariable int id, Model model) {
		model.addAttribute("mystory",mystoryservice.readyOneMystory(id));
		return "mystory/modify";
	}
	
	@GetMapping("/mystory/write")
	public String mystoryWrite() {
		
		return "mystory/write";
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
