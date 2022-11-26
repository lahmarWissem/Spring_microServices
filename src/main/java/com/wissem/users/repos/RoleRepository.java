package com.wissem.users.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.wissem.users.entities.Role;

@RepositoryRestResource(path = "rol")
@CrossOrigin("http://localhost:4200/")
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(String role);
	
	
	
}
