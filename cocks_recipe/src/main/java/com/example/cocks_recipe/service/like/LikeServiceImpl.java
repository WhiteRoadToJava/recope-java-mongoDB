package com.example.cocks_recipe.service.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cocks_recipe.model.Like;
import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.repository.LikeRepository;
import com.example.cocks_recipe.repository.RecipeRepository;

@Service
public class LikeServiceImpl implements LikeService {

    // Injecting the repositories
    @Autowired
    public final RecipeRepository recipeRepository;
    public final LikeRepository likeRepository;

    public LikeServiceImpl(RecipeRepository recipeRepository, LikeRepository likeRepository) {
        this.recipeRepository = recipeRepository;
        this.likeRepository = likeRepository;
    }

    @Override
    public Long likeRecipe(String recipeId) {
        return recipeRepository.findById(recipeId).map(recipe -> {
            // Only add a like if it doesn't already exist
            if (!likeRepository.existsByRecipeId(recipe.getId())) {
                Like like = new Like(recipe);
                likeRepository.save(like);
                recipe.setLikeCount(recipe.getLikeCount() + 1); // Increment the like count
                recipeRepository.save(recipe); // Save the updated recipe
            }
            return (long) recipe.getLikeCount(); // Return the updated like count
        }).orElse(0L); // Return 0 if recipe not found
    }

    @Override
    public Long unLikeRecipe(String recipeId) {
        return likeRepository.findFirstByRecipeId(recipeId).map(like -> {
            Recipe recipe = recipeRepository.findById(recipeId)
                    .orElseThrow(() -> new IllegalArgumentException("Recipe not found with ID: " + recipeId));
            likeRepository.delete(like);
            if (recipe.getLikeCount() > 0) {
                recipe.setLikeCount(recipe.getLikeCount() - 1);
            } else {
                throw new IllegalArgumentException("Like is already zero.");
            }
            recipeRepository.save(recipe); // Save only once
            return (long) recipe.getLikeCount();
        }).orElseThrow(() -> new IllegalArgumentException("No like found for the recipe with ID: " + recipeId));
    }

    @Override
    public Long getLikeCount(String recipeId) {

        // Implement the logic to get the like count for a recipe
        return (Long) recipeRepository.findById(recipeId)
                .map(recipe -> likeRepository.countByRecipeId(recipe.getId()))
                .orElse(0L);
        // Return the like count
    }
}
