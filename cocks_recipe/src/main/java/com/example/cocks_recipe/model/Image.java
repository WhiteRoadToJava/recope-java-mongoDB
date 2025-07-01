package com.example.cocks_recipe.model;

import java.sql.Blob;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "images")
public class Image {
        @Id
        private String id;
        private String fileName;
        private String fileType;

       // @Lob
        private Blob blobImage;

        private String downloadUrl;

        @DBRef
        @Field("recipe_id")
        private String recipe;




}