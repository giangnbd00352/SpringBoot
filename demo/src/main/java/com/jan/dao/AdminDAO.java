package com.jan.dao;

import com.jan.dao.entity.Contact;

public interface AdminDAO {

	public boolean Login(String username, String password);
	
	public Iterable<Contact> findAll();
}
