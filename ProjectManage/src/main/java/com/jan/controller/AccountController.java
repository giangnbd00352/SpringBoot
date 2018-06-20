package com.jan.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jan.entity.Account;
import com.jan.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@GetMapping(value = "/account/list")
	public List<Account> getList() {
		return accountService.getAllAccount();
	}
	
	@GetMapping(value = "/account/{id}")
	public Optional<Account> getAccount(@PathVariable("id") int id) {
		return accountService.getAccount(id);
	}
	
	@PostMapping(value = "/account/add")
	public void addAccount(@RequestBody Account account) {
		accountService.addAccount(account);
	}
	
	@PutMapping(value = "/account/{id}")
	public void updateAccount(@PathVariable(value = "id") int id,
            @Valid @RequestBody Account account) {
		accountService.updateAccount(id, account);
	}
	
	@DeleteMapping(value ="/account/{id}")
	public void deleteAccount(@PathVariable(value = "id") int id) {
		accountService.deleteAccount(id);
	}
}
