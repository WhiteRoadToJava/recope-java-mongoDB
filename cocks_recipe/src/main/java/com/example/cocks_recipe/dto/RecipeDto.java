package com.example.cocks_recipe.dto;

import lombok.Data;

@Data
public class RecipeDto {
        private String id;
        private String title;
        private String instuction;
        private String description;
        private String prepTime;
        private String cookTime;
        private String category;
        private String cuisine;
        private UserDto user;

}