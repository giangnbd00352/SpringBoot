package com.jan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jan.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET )
	public String showLogin(Model model) {
		return "views/login";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.POST)
	public String login(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password , Model model) {
		if (loginService.login(username, password)) {
			return "views/dashboard";
		} else {
			return "views/login";
		}
	}
}
