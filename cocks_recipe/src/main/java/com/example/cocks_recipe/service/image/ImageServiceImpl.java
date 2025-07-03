package com.example.cocks_recipe.service.image;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.cocks_recipe.dto.ImageDto;
import com.example.cocks_recipe.model.Image;
import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.repository.ImageRepository;
import com.example.cocks_recipe.service.recipe.RecipeService;

@Service

public class ImageServiceImpl implements ImageService {
        @Autowired
        private final ImageRepository imageRepository;
        private final RecipeService recipeService;

        public ImageServiceImpl(ImageRepository imageRepository, RecipeService recipeService) {
                this.imageRepository = imageRepository;
                this.recipeService = recipeService;
        }

        @Override
        public Image getImageById(String id) {
                return imageRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Image not found with id: " + id));
        }

        @Override
        public void deleteImage(String id) {
                imageRepository.findById(id).ifPresentOrElse(imageRepository::delete, () -> {
                        throw new IllegalArgumentException("Image not found with id: " + id);
                });
        }

        @Override
        public void updateImage(MultipartFile file, String id) {
                Image image = getImageById(id);
                try {
                        image.setFileName(file.getOriginalFilename());
                        image.setFileType(file.getContentType());
                        image.setBlobImage(file.getBytes());
                        imageRepository.save(image);
                } catch (Exception e) {
                        throw new RuntimeException("Failed to update image" + e);
                }
        }

        @Override
        public ImageDto saveImage(MultipartFile file, String recipeId) {
                Recipe recipe = recipeService.getRecipeById(recipeId);
                try {
                        Image image = new Image();
                        image.setFileName(file.getOriginalFilename());
                        image.setFileType(file.getContentType());
                        image.setBlobImage(file.getBytes());
                        image.setRecipe(recipe);

                        String buildDownloadUrl = "/api/images/image/download/";
                        String downloadUrl = buildDownloadUrl + image.getId();
                        image.setDownloadUrl(downloadUrl);

                        Image savedImage = imageRepository.save(image);
                        savedImage.setDownloadUrl(buildDownloadUrl + savedImage.getId());
                        imageRepository.save(savedImage);

                        ImageDto imageDto = new ImageDto();
                        imageDto.setId(savedImage.getId());
                        imageDto.setFileName(savedImage.getFileName());
                        imageDto.setDownloadUrl(savedImage.getDownloadUrl());

                        return imageDto;
                } catch (Exception e) {
                        throw new RuntimeException("Failed to save image: " + e.getMessage(), e);
                }
        }
}