package com.example.cocks_recipe.service.recipe;

import java.util.List;
import java.util.Set;

import com.example.cocks_recipe.dto.RecipeDto;
import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.model.User;
import com.example.cocks_recipe.request.CreateRecipeRequest;
import com.example.cocks_recipe.request.RecipeUpdateRequest;

public interface RecipeService {

        Recipe createRecipe(CreateRecipeRequest request);

        List<Recipe> getAllRecipes();

        Recipe getRecipeById(String id);

        Recipe updateRecipe(RecipeUpdateRequest request, String recipeId);

        void deleteRecipe(String id);

        Set<String> getAllRecipesCategories();

        Set<String> getAllRecipesCuisine();

        RecipeDto converToDto(Recipe recipe);
        List<RecipeDto> convertToDtoList(List<Recipe> recipes);

        

        static Recipe creaRecipe(CreateRecipeRequest request, User user) {
                Recipe recipe = new Recipe();
                Recipe createRequest = request.getRecipe();
                recipe.setTitle(createRequest.getTitle());
                recipe.setDescription(createRequest.getDescription());
                recipe.setCategory(createRequest.getCategory());
                recipe.setCuisine(createRequest.getCuisine());
                recipe.setIngredients(createRequest.getIngredients());
                recipe.setInstuction(createRequest.getInstuction());
                recipe.setPrepTime(createRequest.getPrepTime());
                recipe.setCookTime(createRequest.getCookTime());
                recipe.setUser(user);
                return recipe;
        }

        static Recipe updateRecipe(Recipe existingRecipe, RecipeUpdateRequest request) {
                existingRecipe.setTitle(request.getTitle());
                existingRecipe.setDescription(request.getDescription());
                existingRecipe.setCategory(request.getCategory());
                existingRecipe.setCuisine(request.getCuisine());
                existingRecipe.setIngredients(request.getIngredients());
                existingRecipe.setInstuction(request.getInstuction());
                existingRecipe.setPrepTime(request.getPrepTime());
                existingRecipe.setCookTime(request.getCookTime());
                return existingRecipe;
        }

}