package com.example.demo.util;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoDbUser extends MongoRepository<User, Long> {
    User findByname(String name);
}
