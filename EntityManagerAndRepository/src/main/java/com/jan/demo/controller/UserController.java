package com.jan.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jan.demo.entity.User;
import com.jan.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

//	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
//	Page<User> usersPageable(Pageable pageable) {
//		return userRepository.findAll(pageable);
//
//	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	List<User> listRepo() {
		return userService.findAll();

	}
	
}
