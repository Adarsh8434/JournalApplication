package com.journal.Application.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.journal.Application.entity.User;

public interface UserRepository extends MongoRepository<User, ObjectId>
{
	User findByUsername (String username); 

}
