package com.example.cocks_recipe.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.request.CreateRecipeRequest;
import com.example.cocks_recipe.request.RecipeUpdateRequest;
import com.example.cocks_recipe.service.recipe.RecipeService;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
        public ResponseEntity<Recipe> createRecipe(@RequestBody CreateRecipeRequest request) {
                System.out.println("Creating recipe:+++++++++++++++++++ " + request + "++++++++++++++++++++" + request.getUser());
                return ResponseEntity.status(200).body(recipeService.createRecipe(request));
        }
        @PutMapping("/{recipeid}/update")
        public ResponseEntity<Recipe> updateRecipe(@RequestBody RecipeUpdateRequest request, @PathVariable String id) {
                return ResponseEntity.status(200).body(recipeService.updateRecipe(request, id));
        }

        @DeleteMapping("/{recipeId}/delete")
        public ResponseEntity<Void> deleteRecipe(@PathVariable String recipeId) {
                recipeService.deleteRecipe(recipeId);
                return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping()
        public ResponseEntity<List<Recipe>> getAllReecipes() {
                return ResponseEntity.ok(recipeService.getAllRecipes());
        }
        

        @GetMapping("/{recipeId}/recipe")
        public ResponseEntity<Recipe> getRecipe(@PathVariable String recipeId) {
                return ResponseEntity.ok(recipeService.getRecipeById(recipeId));
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