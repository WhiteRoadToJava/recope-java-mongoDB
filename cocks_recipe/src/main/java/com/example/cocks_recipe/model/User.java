package com.example.cocks_recipe.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.Data;


@Data
@Document(collection = "users")
public class User {
      @Id
        private String id;
        private String username;

        @DBRef
        @Field("recipe_id")
        private Set<Recipe> recipes;

        @DBRef
        @Field("review_id")
        private List<Review> reviews;

        public User(String username){
                this.username = username;
        }

  public User(String id, String username, Set<Recipe> recipes, List<Review> reviews) {
    this.id = id;
    this.username = username;
    this.recipes = recipes;
    this.reviews = reviews;
  }

  public User() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Set<Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(Set<Recipe> recipes) {
    this.recipes = recipes;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
}