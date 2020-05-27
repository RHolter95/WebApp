package com.richard.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.richard.app.entity.Users;

public interface UserRepo extends CrudRepository<Users, Long> {

	Users findByName(String username);
	Users findByEmail(String email);

}
