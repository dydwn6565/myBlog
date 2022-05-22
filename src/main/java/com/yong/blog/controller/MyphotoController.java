package com.yong.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyphotoController {
	
	@GetMapping("/myphoto")
	public String myphoto() {
		return "myphoto/myphoto";
	}
	
	@GetMapping("/myphoto/write")
	public String myphotoWrite() {
		return "myphoto/write";
	}
	
}
