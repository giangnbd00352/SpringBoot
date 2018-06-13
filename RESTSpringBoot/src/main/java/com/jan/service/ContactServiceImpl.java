package com.jan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jan.model.Contact;
import com.jan.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;


	@Override
	public void addContact(Contact contact) {
		contactRepository.save(contact);

	}

	@Override
	public void updateContact(Contact contact) {
		// contactRepository.(contact);
	}

	@Override
	public Contact getContact(int id) {
		// return contactRepository.f(id);
		return null;
	}

	@Override
	public List<Contact> getAllContact() {
		List<Contact> contacts = new ArrayList<>();
		contactRepository.findAll().forEach(contacts::add);
		return contacts;
	}

	@Override
	public void deleteContact(int id) {
		contactRepository.deleteById(id);

	}

}
