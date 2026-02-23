package com.engineeringdigest.journalApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.engineeringdigest.journalApp.entity.User;


public interface UserRepository extends MongoRepository<User , String> {
    User findByUserName(String userName); //Query method DSL

    void deleteByUserName(String userName);

}
