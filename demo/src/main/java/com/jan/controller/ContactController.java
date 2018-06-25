package com.jan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jan.dao.entity.Contact;
import com.jan.repository.ContactRepository;

@RestController
@RequestMapping("/api")
public class ContactController {
	
	@Autowired
	ContactRepository contactRepository;

	@RequestMapping(value = "/contact", method = RequestMethod.GET )
	public String contact(Model model) {
		return "views/contact";
	}
	
	@GetMapping("/contacts")
	public List<Contact> getAllContact() {
	    return contactRepository.findAll();
	}
	
	@PostMapping("/contacts")
	public Contact createContact(@Valid @RequestBody Contact contact) {
	    return contactRepository.save(contact);
	}
}
