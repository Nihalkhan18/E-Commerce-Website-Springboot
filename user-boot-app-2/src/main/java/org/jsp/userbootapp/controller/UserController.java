package org.jsp.userbootapp.controller;

import java.util.Optional;

import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.repository.UserRepository;
import org.jsp.userbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class UserController {
	@Autowired
	public UserService service;
	
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u)
	{
		return service.saveUser(u);
		
	}
	
	@PutMapping("/users")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User u)
	{
	  return service.updateUser(u);
		
	}
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable int id) {
		return service.findById(id);
		    
	}
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
	  return service.deleteUser(id);
	}
	@GetMapping("/users")
	public ResponseEntity<ResponseStructure<User>> findall(){
		return service.findAll();
	}
	
	
}
