package com.journal.Application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.journal.Application.Service.UserService;
import com.journal.Application.entity.User;
@RestController
@RequestMapping("/user")
public class UserEntryController {
  
	@Autowired
    private UserService userservice;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userservice.getAll();
	}
	
	@PostMapping
	public void createUser(@RequestBody User user) {
		userservice.saveEntry(user); 
	}
	
	@PutMapping("/{userName}")
	public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){
           User userI= userservice.findByUsername(userName);
           if(userI!=null) {
        	   userI.setUsername(user.getUsername());
        	   userI.setPassword(user.getPassword());
        	   userservice.saveEntry( userI);
           } 
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
    
}

