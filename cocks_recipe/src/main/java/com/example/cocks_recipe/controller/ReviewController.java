package com.example.cocks_recipe.controller;

import com.example.cocks_recipe.model.Review;
import com.example.cocks_recipe.repository.ReviewRepository;
import com.example.cocks_recipe.request.ReviewRequest;
import com.example.cocks_recipe.service.review.ReviewService;
import com.example.cocks_recipe.service.review.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/recipe/{recipeId}/review")
    public ResponseEntity<Void> rateRecipe(@PathVariable String recipeId, @RequestBody ReviewRequest review) {
        reviewService.addReview(recipeId, review);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/recipe/{recipeId}/review")
    public ResponseEntity<Integer> getRateCount(@PathVariable String recipeId) {
        Integer totalRating = reviewService.getTotalReviews(recipeId);
        return ResponseEntity.ok(totalRating);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteRating(@RequestParam String ratingId, @RequestParam String recipeId) {
        reviewService.deleteReview(ratingId, recipeId);
        return ResponseEntity.ok("Rating is deleted");
    }
}


