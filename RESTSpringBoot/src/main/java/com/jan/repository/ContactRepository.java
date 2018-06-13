package com.jan.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jan.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{

}
