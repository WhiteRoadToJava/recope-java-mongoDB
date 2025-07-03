package com.example.cocks_recipe.service.like;

public interface LikeService {
        Long likeRecipe(String recipeId);
        Long unLikeRecipe(String recipeId);
        Long getLikeCount(String recipeId);
}