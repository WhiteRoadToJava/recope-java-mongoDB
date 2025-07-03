package com.example.cocks_recipe.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.Data;


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

     public List<String> getIngredients() {
          return ingredients;
     }

     public void setIngredients(List<String> ingredients) {
          this.ingredients = ingredients;
     }

     public int getLikeCount() {
          return likeCount;
     }

     public void setLikeCount(int likeCount) {
          this.likeCount = likeCount;
     }

     public double getAvarageRating() {
          return avarageRating;
     }

     public void setAvarageRating(double avarageRating) {
          this.avarageRating = avarageRating;
     }

     public int getTotalReviews() {
          return totalReviews;
     }

     public void setTotalReviews(int totalReviews) {
          this.totalReviews = totalReviews;
     }

     public User getUser() {
          return user;
     }

     public void setUser(User user) {
          this.user = user;
     }

     public List<Review> getReviews() {
          return reviews;
     }

     public void setReviews(List<Review> reviews) {
          this.reviews = reviews;
     }

     public List<Like> getLikes() {
          return likes;
     }

     public void setLikes(List<Like> likes) {
          this.likes = likes;
     }

     public Image getImage() {
          return image;
     }

     public void setImage(Image image) {
          this.image = image;
     }
}