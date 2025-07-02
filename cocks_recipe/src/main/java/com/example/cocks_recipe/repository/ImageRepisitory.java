package com.example.cocks_recipe.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cocks_recipe.model.Image;

public interface ImageRepisitory extends MongoRepository<Image, String> {

}