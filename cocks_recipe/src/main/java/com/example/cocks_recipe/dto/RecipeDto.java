package com.example.cocks_recipe.dto;

import lombok.Data;




public class RecipeDto {
        private String id;
        private String title;
        private String instuction;
        private String description;
        private String prepTime;
        private String cookTime;
        private String category;
        private String cuisine;
        private ImageDto imageDto;
        private UserDto user;


        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

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

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
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

        public ImageDto getImageDto() {
                return imageDto;
        }

        public void setImageDto(ImageDto imageDto) {
                this.imageDto = imageDto;
        }

        public UserDto getUser() {
                return user;
        }

        public void setUser(UserDto user) {
                this.user = user;
        }
}