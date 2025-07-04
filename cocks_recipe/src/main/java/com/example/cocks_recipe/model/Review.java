package com.example.cocks_recipe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



@Document(collection = "reviews")
public class Review {
        @Id
        private String id;
        private int stars;
        private String feedback;

        @DBRef
        @Field("user_id")
        private User user;

        @DBRef
        @Field("recipe_id")
        private Recipe recipe;

        public Review() {
        }

        public Review(String id, int stars, String feedback, User user, Recipe recipe) {
                this.id = id;
                this.stars = stars;
                this.feedback = feedback;
                this.user = user;
                this.recipe = recipe;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public int getStars() {
                return stars;
        }

        public void setStars(int stars) {
                this.stars = stars;
        }

        public String getFeedback() {
                return feedback;
        }

        public void setFeedback(String feedback) {
                this.feedback = feedback;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public Recipe getRecipe() {
                return recipe;
        }

        public void setRecipe(Recipe recipe) {
                this.recipe = recipe;
        }
}