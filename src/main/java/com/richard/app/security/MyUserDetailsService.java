package com.richard.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.richard.app.entity.Users;
import com.richard.app.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = null;
		user = userRepo.findByName(username);
		
		if(user == null) {
			System.out.println("No User: " + username);
			return null;
		}else {
	 		return new MyUserDetails(user);
		}		
	}
}
