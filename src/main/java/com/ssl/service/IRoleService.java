package com.ssl.service;

import java.util.List;

import com.ssl.entities.Role;
import com.ssl.entities.User;

public interface IRoleService {
	public Role addRole(Role role);
	public Role updateRole(Role role);
	public Role getRoleById(long roleId);
	public List<Role> getRolesByUserId(long userId);
	public List<Role> getAllRoles();
	public boolean deleteRoleById(long roleId);
	public boolean deleteAllRoles();
}
