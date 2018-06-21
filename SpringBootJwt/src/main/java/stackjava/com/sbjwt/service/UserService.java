package stackjava.com.sbjwt.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stackjava.com.sbjwt.entities.User;
import stackjava.com.sbjwt.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	// public static List<User> listUser = new ArrayList<User>();
	public List<User> findAll() {
		return userRepository.findAll();
	}
	//
	// public User findById(int id) {
	// for (User user : listUser) {
	// if (user.getId() == id) {
	// return user;
	// }
	// }
	// return null;
	// }
	//
	// public boolean add(User user) {
	// for (User userExist : listUser) {
	// if (user.getId() == userExist.getId() ||
	// StringUtils.equals(user.getUsername(), userExist.getUsername())) {
	// return false;
	// }
	// }
	// listUser.add(user);
	// return true;
	// }
	//
	// public void delete(int id) {
	// listUser.removeIf(user -> user.getId() == id);
	// }

	public User loadUserByUsername(String username) {
		for (User user : userRepository.findAll()) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public boolean checkLogin(User user) {
		for (User userExist : userRepository.findAll()) {
			if (StringUtils.equals(user.getUsername(), userExist.getUsername())
					&& StringUtils.equals(user.getPassword(), userExist.getPassword())) {
				return true;
			}
		}
		return false;
	}
}