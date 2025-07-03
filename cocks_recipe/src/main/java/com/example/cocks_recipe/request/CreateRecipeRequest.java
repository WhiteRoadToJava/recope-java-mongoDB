package com.example.cocks_recipe.request;

import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.model.User;

import lombok.Data;


public class CreateRecipeRequest {
        private Recipe recipe;
        private User user;


        public Recipe getRecipe() {
                return recipe;
        }

        public void setRecipe(Recipe recipe) {
                this.recipe = recipe;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }
}