package com.example.cocks_recipe.request;

import java.util.List;

import lombok.Data;



public class RecipeUpdateRequest {
        private String title;
        private String instuction;
        private String prepTime;
        private String cookTime;
        private String description;
        private String category;
        private String cuisine;
        private List<String> ingredients;


        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getInstuction() {
                return instuction;
        }

        public void setInstuction(String instuction) {
                this.instuction = instuction;
        }

        public String getPrepTime() {
                return prepTime;
        }

        public void setPrepTime(String prepTime) {
                this.prepTime = prepTime;
        }

        public String getCookTime() {
                return cookTime;
        }

        public void setCookTime(String cookTime) {
                this.cookTime = cookTime;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getCuisine() {
                return cuisine;
        }

        public void setCuisine(String cuisine) {
                this.cuisine = cuisine;
        }

        public List<String> getIngredients() {
                return ingredients;
        }

        public void setIngredients(List<String> ingredients) {
                this.ingredients = ingredients;
        }
}