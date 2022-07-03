package com.ssl.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ssl.entities.User;
import com.ssl.repository.IUserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	IUserRepository userRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findUserByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetails(user);
	}

}
