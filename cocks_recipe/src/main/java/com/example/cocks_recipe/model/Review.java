package com.example.cocks_recipe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}