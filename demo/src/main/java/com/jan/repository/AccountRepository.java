package com.jan.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jan.dao.AdminDAOImp;

@Repository
public class AccountRepository {

	@Autowired
	AdminDAOImp adminDAOImp;

	public boolean authenticate(String username, String password) {
		if (adminDAOImp.Login(username, password)) {
			return true;
		} else {
			return false;
		}
	}
}
