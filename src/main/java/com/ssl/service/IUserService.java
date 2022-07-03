package com.ssl.service;

import java.util.List;

import com.ssl.entities.User;

public interface IUserService {
	
	public User addUser(User user);
	public User updateUser(User user);
	public User getUserById(long userId);
	public List<User> getAllUsers();
	public boolean deleteUserById(long userId);
	public boolean deleteAllUsers();
	public List<User> getUsersByRoleName(String roleName);
	public List<User> getUsersByRoleId(long roleId);
}
