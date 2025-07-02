package com.example.cocks_recipe.model;

import java.sql.Blob;

import javax.sql.rowset.serial.SerialBlob;

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
        private byte[] blobImage;

        private String downloadUrl;

        @DBRef
        @Field("recipe_id")
        private Recipe recipe;

         public Image(String fileName, String fileType, byte[] blobImage, String downloadUrl, Recipe recipe) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.blobImage = blobImage;
        this.downloadUrl = downloadUrl;
        this.recipe = recipe;
    }



}