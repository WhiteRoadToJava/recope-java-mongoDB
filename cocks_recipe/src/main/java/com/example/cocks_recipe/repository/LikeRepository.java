package com.example.cocks_recipe.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cocks_recipe.model.Like;

public interface LikeRepository extends MongoRepository<Like, String> {
        Object countByRecipeId(String recipeId);

        boolean existsByRecipeId(String id);

        Optional<Like> findFirstByRecipeId(String recipeId);
}