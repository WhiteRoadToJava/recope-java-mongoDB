package com.example.cocks_recipe.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cocks_recipe.model.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    // Additional query methods can be defined here if needed
}