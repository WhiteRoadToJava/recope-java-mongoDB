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


    public Image() {
    }

    public Image(String fileName, String fileType, byte[] blobImage, String downloadUrl, Recipe recipe) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.blobImage = blobImage;
        this.downloadUrl = downloadUrl;
        this.recipe = recipe;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getBlobImage() {
        return blobImage;
    }

    public void setBlobImage(byte[] blobImage) {
        this.blobImage = blobImage;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}