package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;


	public User saveUserDaetails(User user) {
		
		return userRepository.save(user);
	}



	public User findUserById(Long userId) {
		
		return userRepository.findByUserId(userId);
	}
}
