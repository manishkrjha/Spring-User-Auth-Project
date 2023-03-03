package com.example.demo.service;

//import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;

//@Service
public interface UserService {
	
	public UserDetails createuser(UserDetails user);
	
	public boolean checkEmail(String email);
}
