package com.sandra.coursePlatform.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sandra.coursePlatform.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	 User findByUsername(String username);
	 User findByEmail(String email);
}
