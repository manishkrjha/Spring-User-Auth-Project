package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncode;

	@Override
	public UserDetails createuser(UserDetails user) {
		
//		user.setPassword(passwordEncode.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		
		return userRepo.existsByEmail(email);
	}

}
