package com.jan.demo.service;

import java.util.List;

import com.jan.demo.entity.User;

public interface UserService {
	
	//public Page<User> findAll(Pageable pageable);
	
	public List<User> findAll();
}
