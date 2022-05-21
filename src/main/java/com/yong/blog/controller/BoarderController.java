package com.yong.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoarderController {
	
	@GetMapping("/myIdea")
	public String myIdea() {
		return "myIdea";
	}
	
	@GetMapping("/myphoto")
	public String myphoto() {
		return "myphoto";
	}
	
	@GetMapping("/mystory")
	public String mystory() {
		return "mystory/mystory";
	}
	
	@GetMapping("/mystory/{id}")
	public String mystoryDetail(@PathVariable int id, Model model) {
		model.addAttribute("id",id);
		return "mystory/detail";
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
