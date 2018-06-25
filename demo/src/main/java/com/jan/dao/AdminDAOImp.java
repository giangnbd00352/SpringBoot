package com.jan.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jan.dao.entity.Account;
import com.jan.dao.entity.Contact;

@Transactional
@Repository
public class AdminDAOImp implements AdminDAO {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean Login(String username, String password) {
		String sql = "Select a from  Account a Where a.username = :username AND a.password = :password ";

        Query query = entityManager.createQuery(sql, Account.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Account account = (Account) query.getSingleResult();
		if (account != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Iterable<Contact> findAll() {
		//List<Account> account
		return null;
	}

}
