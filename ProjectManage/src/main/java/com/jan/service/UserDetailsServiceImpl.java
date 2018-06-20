package com.jan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jan.entity.Account;
import com.jan.entity.Role;
import com.jan.repository.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(email);
		if ( account == null) {
			throw new UsernameNotFoundException("account not found");
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		List<Role> roles = account.getRoles();
		for (Role role : roles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new User(account.getEmail(), account.getPass(), grantedAuthorities);
	}
}
