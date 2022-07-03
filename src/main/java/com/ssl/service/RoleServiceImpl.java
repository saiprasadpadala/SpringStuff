package com.ssl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssl.entities.Role;
import com.ssl.repository.IRoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleRepository roleRepository;	
	
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
	public boolean deleteRoleById(long roleId) {
		roleRepository.deleteRolesFromJointTableByRoleId(roleId);
		Role role = getRoleById(roleId);
		roleRepository.delete(role);
		return true;
	}

	@Override
	public boolean deleteAllRoles() {
		roleRepository.deleteAllRolesFromJointTableByRoleId();
		roleRepository.deleteAll();
		return true;
	}
	
}