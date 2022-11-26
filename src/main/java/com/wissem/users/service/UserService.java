package com.wissem.users.service;

import java.util.List;

import com.wissem.users.entities.Role;
import com.wissem.users.entities.User;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	
	 List <User> findAll();
	    
	    User updateUser(User u);
	    void deleteUser(User u);
	     void deleteUserById(Long id);
	     User getUser(Long idUser);
}
