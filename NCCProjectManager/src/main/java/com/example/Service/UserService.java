package com.example.Service;

import java.util.List;

import com.example.Entity.User;
import com.example.Model.UserDTO;

public interface UserService {

	public void save(final User user);

	public void update(final User user);

	public User findById(final int id);
	
	public void delete(final int id);

	public List<UserDTO> findAll();
	
	public  User loadUserByUsername(String username);
	
	public  boolean checkLogin(User user);

	
}
