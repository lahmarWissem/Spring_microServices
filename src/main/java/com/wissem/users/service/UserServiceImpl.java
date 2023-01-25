package com.wissem.users.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wissem.users.entities.Role;
import com.wissem.users.entities.User;
import com.wissem.users.repos.RoleRepository;
import com.wissem.users.repos.UserRepository;

@Transactional
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRep;
	
	@Autowired
	RoleRepository roleRep;
	
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User saveUser(User user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRep.save(user);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRep.findByUsername(username);
		Role r = roleRep.findByRole(rolename);
		
		usr.getRoles().add(r);
		return usr;
	}

	
	@Override
	public Role addRole(Role role) {
		return roleRep.save(role);
	}

	@Override
	public User findUserByUsername(String username) {	
		return userRep.findByUsername(username);
	}
	@Override
    public List <User> findAll() {
        return userRep.findAll();
    }

	@Override
	public User updateUser(User u) {
		return userRep.save(u);
	}

	@Override
	public void deleteUser(User u) {
		userRep.delete(u);
	}

	@Override
	public void deleteUserById(Long idUser) {
		userRep.deleteById(idUser);
	}

	@Override
	public User getUser(Long idUser) {
		return userRep.findById(idUser).get();
	}

	


}
