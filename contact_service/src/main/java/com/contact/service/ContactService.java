package com.contact.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;

	public Contact saveContactDetails(Contact contact) {
		
		return contactRepository.save(contact);
	}



	@SuppressWarnings("unchecked")
	public  List<Contact> findContactByUserId(Long userId) {
		System.out.println("contuserIdac"+userId);
		return (List<Contact>) contactRepository.findContactByUserId(userId);
	}
	
	
}
