package com.modestack.repository;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.modestack.model.User;

//@Repository
public interface UserRepository extends MongoRepository<User, ObjectId>{

}
