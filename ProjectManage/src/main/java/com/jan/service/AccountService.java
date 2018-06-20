package com.jan.service;

import java.util.List;
import java.util.Optional;

import com.jan.entity.Account;

public interface AccountService {

	void addAccount(Account account);
	void updateAccount(int id, Account account);
	Optional<Account> getAccount(int id);
	List<Account> getAllAccount();
	void deleteAccount(int id);
}
