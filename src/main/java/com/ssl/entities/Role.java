package com.ssl.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
	private RoleName roleName;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	public Role() {
		super();
	}
	
	public Role(RoleName roleName) {
		super();
		this.roleName = roleName;
	}

	public Role(Long roleId, RoleName roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	}
    
	
}
