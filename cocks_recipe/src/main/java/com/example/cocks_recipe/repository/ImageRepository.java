package com.example.cocks_recipe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cocks_recipe.model.Image;

import java.util.Optional;

public interface ImageRepository extends MongoRepository<Image, String> {
        Image findByRecipeId(String recipeId);
}