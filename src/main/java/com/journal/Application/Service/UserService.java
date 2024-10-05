package com.journal.Application.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.journal.Application.Repository.UserRepository;
import com.journal.Application.entity.User;

@Component
public class UserService {
	@Autowired
	private UserRepository userrepository ;
	
	public void saveEntry(User user) {
		userrepository.save(user);
	}
	public List<User> getAll(){
		return userrepository.findAll();
	}   
	public Optional<User> findById(ObjectId id) { 
		return userrepository.findById(id);
	}
 public void deleteById(ObjectId id) {
	 userrepository.deleteById(id);
}
 public User findByUsername(String username) {
	 return userrepository.findByUsername(username);
 }
 
}
