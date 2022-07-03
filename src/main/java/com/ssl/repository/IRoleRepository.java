package com.ssl.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ssl.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{
	
	@Query(value = "Select * from Role where role_id in(Select role_id_fk from user_role where user_id_fk =?1)", nativeQuery = true)
	public List<Role> findAllRolesByUserId(long userId);
	
	@Modifying
	@Transactional
	@Query(value = "Delete from user_role where role_id_fk =?1", nativeQuery = true)
	public void deleteRolesFromJointTableByRoleId(long roleId);
	
	@Modifying
	@Transactional
	@Query(value = "Delete from user_role", nativeQuery = true)
	public void deleteAllRolesFromJointTableByRoleId();
	
}
