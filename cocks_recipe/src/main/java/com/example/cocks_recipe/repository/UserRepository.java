package com.example.cocks_recipe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cocks_recipe.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

}