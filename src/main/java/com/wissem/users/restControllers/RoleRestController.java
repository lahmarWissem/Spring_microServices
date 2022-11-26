package com.wissem.users.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wissem.users.entities.Role;
import com.wissem.users.repos.RoleRepository;


@RestController
@RequestMapping("/api/rol")
@CrossOrigin("*")
public class RoleRestController {

	@Autowired
	RoleRepository rolerep;

	@RequestMapping(method = RequestMethod.GET)
	public List<Role> getAllRoles() {
		return rolerep.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Role getRoleByIduser(@PathVariable("id") Long id) {
		return rolerep.findById(id).get();
		
	}
}
