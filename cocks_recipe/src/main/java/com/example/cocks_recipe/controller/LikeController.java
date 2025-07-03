package com.example.cocks_recipe.controller;

import com.example.cocks_recipe.service.like.LikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/likes")
public class LikeController {
        @Autowired
        private final LikeService likeService;

        public LikeController(LikeService likeService) {
                this.likeService = likeService;
        }

        @PostMapping("/recipe/{recipeId}/like")
        public ResponseEntity<Long> likeRecipe(@PathVariable String recipeId) {
                Long likeCount = likeService.likeRecipe(recipeId);
                return ResponseEntity.ok(likeCount);
        }

        @PostMapping("/recipe/{recipeId}/unlike")
        public ResponseEntity<Long> unLikeRecipe(@PathVariable String recipeId) {
                Long likeCount = likeService.unLikeRecipe(recipeId);
                return ResponseEntity.ok(likeCount);
        }
        @GetMapping("/recipe/{recipeId}/count-count")
        public ResponseEntity<Long> getLikeCount(@PathVariable String recipeId) {
                Long likeCount = likeService.getLikeCount(recipeId);
                return ResponseEntity.ok(likeCount);
        }

}