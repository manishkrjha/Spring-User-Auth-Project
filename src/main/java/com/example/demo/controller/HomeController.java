package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "userLogin";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
}
