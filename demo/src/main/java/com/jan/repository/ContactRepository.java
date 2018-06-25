package com.jan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jan.dao.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
}
