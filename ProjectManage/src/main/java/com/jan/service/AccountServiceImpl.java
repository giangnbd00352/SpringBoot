package com.jan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jan.entity.Account;
import com.jan.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void addAccount(Account account) {
		accountRepository.save(account);
	}

	@Override
	public void updateAccount(int id, Account account) {
		Optional<Account> prj = accountRepository.findById(id);
		if (prj.isPresent())
		{
			account.setAccID(id);
			accountRepository.save(account);
		}
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public void deleteAccount(int id) {
		accountRepository.deleteById(id);
	}

	@Override
	public Optional<Account> getAccount(int id) {
		return accountRepository.findById(id);
	}
}
