package org.jsp.userbootapp.service;

import java.lang.StackWalker.Option;
import java.sql.Struct;
import java.util.Optional;

import org.jsp.userbootapp.dao.UserDao;
import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.exception.IdNotFoundException;
import org.jsp.userbootapp.exception.InvalidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
 @Autowired
 private UserDao dao;
 
 public ResponseEntity<ResponseStructure<User>> saveUser(User u){
	 ResponseStructure<User> structure= new ResponseStructure<>();
	    structure.setData(dao.saveUser(u));
		structure.setMessage("user is added with id: "+u.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	 
 }
 public ResponseEntity<ResponseStructure<User>> updateUser(User u){
	 ResponseStructure<User> structure= new ResponseStructure<>();
	 structure.setData(dao.saveUser(u));
	 structure.setMessage("User is update");
	 structure.setStatusCode(HttpStatus.ACCEPTED.value());
	 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
 }
 public ResponseEntity<ResponseStructure<User>> findById(int id)
 {
	 ResponseStructure<User>  structure= new ResponseStructure<>();
	 Optional<User> recUser= dao.findById(id);
	 if(recUser.isPresent())
	 {
		 structure.setData(recUser.get());
		 structure.setMessage("USer FOund" );
		 structure.setStatusCode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
	 }
	 throw new IdNotFoundException();
 }
 
 public ResponseEntity<ResponseStructure<String>> deleteUser(int id)
 {
	 ResponseStructure<String> structure= new ResponseStructure<>();
	 Optional<User> recUser=dao.findById(id);
	 if(recUser.isPresent()) {
		 structure.setMessage("User deleted");
		 structure.setData("User Found");
		 structure.setStatusCode(HttpStatus.OK.value());
		 dao.deleteUser(id);
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
	 }
	 throw new IdNotFoundException();
 }
 
 
 public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password)
 {
	 ResponseStructure<User>  structure= new ResponseStructure<>();
	 Optional<User> recUser= dao.verifyUser(email, password);
	 if(recUser.isPresent())
	 {
		 structure.setData(recUser.get());
		 structure.setMessage("USer FOund" );
		 structure.setStatusCode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
	 }
	 throw new InvalidCredentialException();
 }
 public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password ){
	 ResponseStructure<User> structure= new ResponseStructure<>();
	 Optional<User> recUser= dao.verifyUser(phone, password);
	 if(recUser.isPresent())
	 {
		 structure.setData(recUser.get());
		 structure.setMessage("USer FOund" );
		 structure.setStatusCode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
	 }
	 throw new InvalidCredentialException();
 }
public ResponseEntity<ResponseStructure<User>> findAll() {
	
	return null;
}
	
}
