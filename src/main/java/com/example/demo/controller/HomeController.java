package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

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
	
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute UserDetails user, HttpSession session) {
				
		boolean emailAlreadyExists = userService.checkEmail(user.getEmail());
		
		if(emailAlreadyExists) {
			System.out.println("A user with this email has already been registered");
			
			session.setAttribute("msg", "A user with this email has already been registered");
		}else {
			UserDetails userDetail = userService.createuser(user);
			
			if(userDetail != null) {
				System.out.println("User Registration successful!");
				
				session.setAttribute("msg", "User Registration successful!");
			}else {
				System.out.println("Error occurred!!!!");
				
				session.setAttribute("msg", "Error occurred!!!!");
			}
		}
		
		
		
//		The redirect:/ will take care of caching
		return "redirect:/signup";
	}
	
}
