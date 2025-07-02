package com.example.cocks_recipe.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.cocks_recipe.dto.ImageDto;
import com.example.cocks_recipe.model.Image;
import com.example.cocks_recipe.service.image.ImageService;

import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource; // Use Spring's Resource

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/images")
public class ImageController {

        @Autowired
        private final ImageService imageService;

        public ImageController(ImageService imageService) {
                this.imageService = imageService;
        }

        @PostMapping("/upload")
        public ResponseEntity<ImageDto> uploadImage(@RequestParam("file") 
                                                        MultipartFile file,
                                                        @RequestParam("recipeId") String recipeId) {
                ImageDto savedImage = imageService.saveImage(file, recipeId);
                return ResponseEntity.ok(savedImage);
        }



        @PutMapping("/image/{imageId}/update")
        public ResponseEntity<String> updateImage(@PathVariable String imageId,
                        @RequestBody MultipartFile file) {
                imageService.updateImage(file, imageId);
                return ResponseEntity.ok("Image updated successfully");
        }

        @DeleteMapping("/image/{imageId}/delete")
        public ResponseEntity<String> deleteImage(@PathVariable String imageId) {
                imageService.deleteImage(imageId);
                return ResponseEntity.ok("Image deleted successfully");
        }

        @GetMapping("/image/download/{imageId}")
        public ResponseEntity<ByteArrayResource> downloadImage(@PathVariable String imageId) {
                Image image = imageService.getImageById(imageId);
                ByteArrayResource resource = new ByteArrayResource(image.getBlobImage());

                return ResponseEntity.ok()
                                .contentType(MediaType.parseMediaType(image.getFileType()))
                                .header(HttpHeaders.CONTENT_DISPOSITION,
                                                "attachment; filename=\"" + image.getFileName() + "\"")
                                .contentLength(image.getBlobImage().length)
                                .body(resource);
        }
}
