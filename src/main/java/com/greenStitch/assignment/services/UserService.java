package com.greenStitch.assignment.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.greenStitch.assignment.entity.User;

public interface UserService extends UserDetailsService {

	public User findByUsername(String username);
	
//	public UserDTO addNewUser(SignupDTO signupDTO);
}