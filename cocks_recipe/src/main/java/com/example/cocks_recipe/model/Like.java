package com.example.cocks_recipe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "likes")
public class Like {

        @Id
        private String id;

        @Field("recipe_id")
        @DBRef
        private Recipe recipe;

        @Field("user_id")
        @DBRef
        private User user;

        public Like (Recipe recipe) {
                this.recipe = recipe;
        }

        public Like() {
        }

        public Like(String id, Recipe recipe, User user) {
                this.id = id;
                this.recipe = recipe;
                this.user = user;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

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