package com.example.cocks_recipe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.Data;



@Data
@Document(collection = "recipes")
public class Recipe {
   @Id
        private String id;
        private String title;
        private String instuction;
        private String description;
        private String prepTime;
        private String cookTime;
        private String category;
        private String cuisine;

        @Field("ingredients")
        private List<String> ingredients;
        private int likeCount;
        private double avarageRating;
        private int totalReviews;

        @DBRef
        @Field("user_id")
        private User user;

        @DBRef
        private List<Review> reviews;

        @DBRef
        private List<Like> likes;

        @DBRef
        private Image image;


     public Recipe(String id, String title, String instuction, String description, String prepTime, String cookTime, String category, String cuisine, List<String> ingredients, int likeCount, double avarageRating, int totalReviews, User user, List<Review> reviews, List<Like> likes, Image image) {
          this.id = id;
          this.title = title;
          this.instuction = instuction;
          this.description = description;
          this.prepTime = prepTime;
          this.cookTime = cookTime;
          this.category = category;
          this.cuisine = cuisine;
          this.ingredients = ingredients;
          this.likeCount = likeCount;
          this.avarageRating = avarageRating;
          this.totalReviews = totalReviews;
          this.user = user;
          this.reviews = reviews;
          this.likes = likes;
          this.image = image;
     }

     public Recipe() {
     }


}