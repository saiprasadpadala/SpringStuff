package com.ssl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssl.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "Select * from User where id in(Select user_id_fk from user_role where role_id_fk =?1)", nativeQuery = true)
	public List<User> findAllUsersByRoleId(long roleId);
	
	@Query(value = "Select * from User where id in(Select user_id_fk from user_role where role_id_fk in"
			+ "(Select role_id from role where role_name =?1))", nativeQuery = true)
	public List<User> findAllUsersByRoleName(String roleName);
}
