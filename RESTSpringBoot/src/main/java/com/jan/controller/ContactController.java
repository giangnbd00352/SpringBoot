package com.jan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jan.model.Contact;
import com.jan.service.ContactService;

@RestController
public class ContactController {

	//autowired gan bean vao bien
	@Autowired
	ContactService contactService;
	
	@PostMapping("/contact/add")
	public void addContact(@RequestBody Contact contact) {
		contactService.addContact(contact);
	}
	
	@GetMapping(value = "/contacts", produces = {"application/xml", "application/json"})
	public List<Contact> getAllContact() {
		return contactService.getAllContact();
	}
	
	@PutMapping(value = "/contact/update")
	public void updateContact(@RequestBody Contact contact) {
		contactService.updateContact(contact);
	}
	
	@GetMapping("/contact/{id}")
	public Contact getContact(@PathVariable("id") int id) {
		return contactService.getContact(id);
	}
	
	@DeleteMapping("/contact/release/{id}")
	public void releaseContact(@PathVariable int id) {
		contactService.deleteContact(id);
	}
}
