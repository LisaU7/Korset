package main.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

import main.dao.UserRepository;
import main.entity.User;

@ApplicationScoped
public class UserService {

	@Inject
	User user;

	@Inject
	UserRepository userRepository;

	// ADD USER
	public void addUser(User user) {
		userRepository.persist(user);
	}

	// GET USER - ID
	public User getUser(int userId) {
		User user = userRepository.findById(userId);
		return user;
	}

//	//GET USER - NAME
//	public User getUser(String userName) {
//		return userRepository.findByName(userName);
//	}

	// DELETE USER - ID
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	// GET ALL
	public List<User> getAllUsers() {
		return userRepository.getAll();
	}

}
