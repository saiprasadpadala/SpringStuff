package com.ssl.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssl.entities.Role;
import com.ssl.entities.User;
import com.ssl.repository.IRoleRepository;
import com.ssl.repository.IUserRepository;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public Role addRole(Role role) {
		Role addedRole = roleRepository.save(role);
		return addedRole;
	}

	@Override
	public Role updateRole(Role role) {
		Role updatedRole = roleRepository.save(role);
		return updatedRole;
	}

	@Override
	public Role getRoleById(long roleId) {
		
		Role role = roleRepository.findById(roleId).orElse(null);
		return role;
	}

	@Override
	public List<Role> getRolesByUserId(long userId) {
		List<Role> userRoles = roleRepository.findAllRolesByUserId(userId);
		return userRoles;
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> allRoles = roleRepository.findAll();
		return allRoles;
	}

	@Override
	public List<User> getUsersByRole(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRoleById(long roleId) {
		roleRepository.deleteRolesFromJointTableByRoleId(roleId);
		Role role = getRoleById(roleId);
		roleRepository.delete(role);
		return true;
	}

	@Override
	public boolean deleteAllRoles() {
		roleRepository.deleteAll();
		return true;
	}

}
