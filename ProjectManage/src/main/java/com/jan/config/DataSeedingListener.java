package com.jan.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.jan.entity.Account;
import com.jan.entity.Role;
import com.jan.repository.AccountRepository;
import com.jan.repository.RoleRepository;



@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private RoleRepository	roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
		
        if (accountRepository.findByEmail("admin@gmail.com") == null) {
            Account admin = new Account();
            admin.setEmail("admin@gmail.com");
            admin.setPass(passwordEncoder.encode("123456"));
            admin.setName("Jan");
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            admin.setRoles(roles);
            accountRepository.save(admin);
        }

        // Member account
        if (accountRepository.findByEmail("member@gmail.com") == null) {
        	Account user = new Account();
            user.setEmail("member@gmail.com");
            user.setPass(passwordEncoder.encode("123456"));
            user.setName("User");
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            accountRepository.save(user);
        }
	}

}
