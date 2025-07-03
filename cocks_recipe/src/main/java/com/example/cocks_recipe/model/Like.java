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
}