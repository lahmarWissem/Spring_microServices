package com.wissem.users.service;


import java.util.List;

import com.wissem.users.entities.Role;

public interface RoleService {
	
	 List <Role> findAll();  
	 Role saveRole(Role r);
	 Role updateRole(Role r);
	     Role getRole (Long idRole);

}
