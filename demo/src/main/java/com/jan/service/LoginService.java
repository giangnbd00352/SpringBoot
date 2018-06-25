package com.jan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jan.repository.AccountRepository;

@Service
public class LoginService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public boolean login(String username, String password) {
		return accountRepository.authenticate(username, password);
	}
}
