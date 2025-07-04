package com.example.cocks_recipe.repository;

import com.example.cocks_recipe.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReviewRepository extends MongoRepository<Review, String> {
    int countAllByRecipeId(String recipeId);

   Optional<Review> findByRecipeIdAndUserId(String recipeId, String userId);
}
