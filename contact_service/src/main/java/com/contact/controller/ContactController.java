package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/")
	public Contact saveContactDetails(@RequestBody Contact contact) {
System.out.println("contact####"+contact);
		return contactService.saveContactDetails(contact);
	}

	@GetMapping("/user/{userId}")
	public List<Contact> findContactByUserId(@PathVariable("userId") Long userId) {
		System.out.println("contuserIdact####"+userId);
		return contactService.findContactByUserId(userId);

	}


}
