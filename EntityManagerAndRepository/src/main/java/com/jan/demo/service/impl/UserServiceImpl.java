package com.jan.demo.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jan.demo.entity.User;
import com.jan.demo.repository.UserRepository;
import com.jan.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@PersistenceContext
    private EntityManager entityManager;

//	@Override
//	public Page<User> findAll(Pageable pageable) {
//		return userRepository.findAll(pageable);
//	}
	
//	@Override
//	public List<User> findAll() {
//		return userRepository.findAll();
//	}
	
	@Override
	public List<User> findAll() {
		String sql = "Select u from User u";
		Query query = entityManager.createQuery(sql, User.class);
		List<User> list = query.getResultList();		
		return list;
	}

	
}
