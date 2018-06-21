package com.example.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.impl.UserDaoImpl;
import com.example.Entity.User;
import com.example.Model.UserDTO;
import com.example.Service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDaoImpl userDao;
	

	@Override
	public List<UserDTO> findAll() {
		List<User> list = userDao.findAll();
		List<UserDTO> listU = new ArrayList<UserDTO>();
		for (User user : list) {
			UserDTO u = new UserDTO();
			u.setEmail(user.getUsername());
			u.setId(user.getId());

			listU.add(u);
		}
		return listU;
	}

	public User findById(final int id) {
		return userDao.findById(id);
	}

	public void save(final User user) {
		userDao.save(user);
	}

	public void update(final User user) {
		userDao.update(user);
	}

	public void delete(final int id) {
		User customer = userDao.findById(id);
		if (customer != null) {
			userDao.delete(customer);
		}
	}

	@Override
	public User loadUserByUsername(String username) {
		for (User user : userDao.findAll()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean checkLogin(User user) {
		for (User userExist : userDao.findAll()) {
			if (StringUtils.equals(user.getUsername(), userExist.getUsername())
					&& StringUtils.equals(user.getPassword(), userExist.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
}