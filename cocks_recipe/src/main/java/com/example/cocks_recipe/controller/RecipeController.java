package com.example.cocks_recipe.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cocks_recipe.dto.RecipeDto;
import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.request.CreateRecipeRequest;
import com.example.cocks_recipe.request.RecipeUpdateRequest;
import com.example.cocks_recipe.service.recipe.RecipeService;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;






@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
        @Autowired
        private final RecipeService recipeService;

        public RecipeController(RecipeService recipeService) {
                this.recipeService = recipeService;
        }



    @PostMapping()
        public ResponseEntity<RecipeDto> createRecipe(@RequestBody CreateRecipeRequest request) {
                Recipe createdRecipe = recipeService.createRecipe(request);
                RecipeDto recipeDto = recipeService.converToDto(createdRecipe);
                return new ResponseEntity<>(recipeDto, HttpStatus.CREATED);
                
        }
        @PutMapping("/{recipeid}/update")
        public ResponseEntity<RecipeDto> updateRecipe(@RequestBody RecipeUpdateRequest request, @PathVariable String id) {
                Recipe updatedRecipe = recipeService.updateRecipe(request, id);
                RecipeDto recipeDto = recipeService.converToDto(updatedRecipe);
                return new ResponseEntity<>(recipeDto, HttpStatus.OK);
        }

        @DeleteMapping("/{recipeId}/delete")
        public ResponseEntity<Void> deleteRecipe(@PathVariable String recipeId) {
                recipeService.deleteRecipe(recipeId);
                return ResponseEntity.status(204).build();
        }

        @GetMapping()
        public ResponseEntity<List<RecipeDto>> getAllReecipes() {
                List<Recipe> allRecipes = recipeService.getAllRecipes();
                List<RecipeDto> recipes = recipeService.convertToDtoList(allRecipes);
                return ResponseEntity.ok(recipes);
        }
        

        @GetMapping("/{recipeId}/recipe")
        public ResponseEntity<RecipeDto> getRecipe(String recipeId) {
                Recipe recipe = recipeService.getRecipeById(recipeId);
                RecipeDto recipeDto = recipeService.converToDto(recipe);
                return new ResponseEntity<>(recipeDto, HttpStatus.OK);
                
        }

        @GetMapping("/categories")
        public ResponseEntity<Set<String>> getAllRecipesCategories() {
                return ResponseEntity.ok(recipeService.getAllRecipesCategories());
        }

        @GetMapping("/cuisines")
        public ResponseEntity<Set<String>> getAllRecipesCuisine() {
                return ResponseEntity.ok(recipeService.getAllRecipesCuisine());
        }

}