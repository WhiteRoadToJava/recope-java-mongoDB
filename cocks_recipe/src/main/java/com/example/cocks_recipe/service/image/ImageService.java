package com.example.cocks_recipe.service.image;

import org.springframework.web.multipart.MultipartFile;

import com.example.cocks_recipe.dto.ImageDto;
import com.example.cocks_recipe.model.Image;

public interface ImageService {

        Image getImageById(String id);
        void deleteImage(String id);
        void updateImage(MultipartFile file ,String id);
        
        ImageDto saveImage(MultipartFile file, String recipeId);
}