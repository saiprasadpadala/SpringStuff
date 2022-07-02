package com.ssl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssl.entities.User;
import com.ssl.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository; 
	
	@Override
	public User addUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}

	@Override
	public User getUserById(long userId) {
		User user = userRepository.findById(userId).orElse(null);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers;
	}

	@Override
	public List<User> getUsersByRole(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByRole(long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(long userId) {
		User user = getUserById(userId);
		userRepository.delete(user);
		return true;
	}

	@Override
	public boolean deleteAllUsers() {
		userRepository.deleteAll();
		return true;
	}

}