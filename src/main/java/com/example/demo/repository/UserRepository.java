package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, String>{
	
	public boolean existsByEmail(String email);
	
}
