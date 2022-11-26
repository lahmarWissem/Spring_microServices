package com.wissem.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wissem.users.entities.Role;
import com.wissem.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

		User findByUsername(String username);
		

}
