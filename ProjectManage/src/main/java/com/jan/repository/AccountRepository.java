package com.jan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jan.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	Account findByEmail(String email);
}
