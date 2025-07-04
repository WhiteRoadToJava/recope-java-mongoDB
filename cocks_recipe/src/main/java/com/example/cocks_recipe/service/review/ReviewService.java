package com.example.cocks_recipe.service.review;

import com.example.cocks_recipe.model.Review;
import com.example.cocks_recipe.request.ReviewRequest;

public interface ReviewService {
    void addReview(String recipeId,  ReviewRequest review);
    void deleteReview(String recipeId,  String  reviewId);
    int getTotalReviews(String recipeId);


}
