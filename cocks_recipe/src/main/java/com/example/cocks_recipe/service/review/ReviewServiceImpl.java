package com.example.cocks_recipe.service.review;

import com.example.cocks_recipe.exception.ResourceNotFoundException;
import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.model.Review;
import com.example.cocks_recipe.model.User;
import com.example.cocks_recipe.repository.RecipeRepository;
import com.example.cocks_recipe.repository.ReviewRepository;
import com.example.cocks_recipe.repository.UserRepository;
import com.example.cocks_recipe.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private final ReviewRepository reviewRepository; // Removed @Autowired here, using constructor injection
    private final RecipeRepository recipeRepository; // Added final, using constructor injection
    private final UserRepository userRepository; // Added final, using constructor injection

    // Constructor Injection (Recommended for all dependencies)
    public ReviewServiceImpl(ReviewRepository reviewRepository, RecipeRepository recipeRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
    }
    public void addReview(String recipeId, ReviewRequest request) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with ID: " + recipeId));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + request.getUserId()));

        reviewRepository.findByRecipeIdAndUserId(recipeId, user.getId())
                .ifPresentOrElse(
                        existingReview -> updateReview(existingReview, request), // Pass request for updates
                        () -> createNewReview(request, recipe) // Pass request and recipe for new review
                );

        // Recalculate average rating and total count AFTER potential review changes
        // Assuming calculateAverageRating and getTotalReviews correctly query the database
        double averageRating = recipe.calculateAverageRating(); // Better to get from service
        recipe.setAvarageRating(averageRating);
        int totalRateCount = getTotalReviews(recipeId);
        recipe.setTotalRateCount(totalRateCount);
        recipeRepository.save(recipe);
    }

    private void updateReview(Review existingReview , ReviewRequest request) {
        existingReview.setStars(request.getStars());
        existingReview.setFeedback(request.getFeedback());
        reviewRepository.save(existingReview);
    }
    private void createNewReview(ReviewRequest request, Recipe recipe) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        Review newReview = new Review();
        newReview.setUser(user);
        newReview.setRecipe(recipe);
        newReview.setStars(request.getStars());
        newReview.setFeedback(request.getFeedback());
    }

    @Override
    public void deleteReview(String recipeId, String reviewId) {
        reviewRepository.findById(reviewId).ifPresentOrElse(review -> {
            Recipe recipe = recipeRepository.findById(recipeId)
                    .orElseThrow(() -> new ResourceNotFoundException("Recipe", recipeId)); // Using your custom exception
            recipe.getReviews().remove(review);
            recipeRepository.save(recipe);

            reviewRepository.delete(review);
        }, () -> {
            throw new ResourceNotFoundException("Review", reviewId); // Using your custom exception
        });
    }


    @Override
    public int  getTotalReviews(String recipeId) {
        return reviewRepository.countAllByRecipeId(recipeId);
    }
}
