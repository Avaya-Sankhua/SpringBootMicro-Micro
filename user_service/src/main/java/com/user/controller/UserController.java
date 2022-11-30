package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/")
	public User saveUserDaetails(@RequestBody User user) {

		return userService.saveUserDaetails(user);
	}

	@GetMapping("/{userId}")
	public User findUserById(@PathVariable("userId") Long userId) {
		
		User user= userService.findUserById(userId);
		//http://localhost:9002/contact/user/1311
		
		List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/" + user.getUserId(), List.class);
		 user.setContacts(contacts);
		
		return user;

	}

}
