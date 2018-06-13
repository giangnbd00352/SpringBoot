package com.jan.service;

import java.util.List;

import com.jan.model.Contact;

public interface ContactService {

	void addContact(Contact contact);
	void updateContact(Contact contact);
	Contact getContact(int id);
	List<Contact> getAllContact();
	void deleteContact(int id);
	
}
