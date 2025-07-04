package com.example.cocks_recipe.service.recipe;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cocks_recipe.dto.ImageDto;
import com.example.cocks_recipe.dto.RecipeDto;
import com.example.cocks_recipe.dto.UserDto;
import com.example.cocks_recipe.model.Image;
import com.example.cocks_recipe.model.Recipe;
import com.example.cocks_recipe.model.User;
import com.example.cocks_recipe.repository.ImageRepository;
import com.example.cocks_recipe.repository.RecipeRepository;
import com.example.cocks_recipe.repository.UserRepository;
import com.example.cocks_recipe.request.CreateRecipeRequest;
import com.example.cocks_recipe.request.RecipeUpdateRequest;

@Service

public class RecipeServiceImpl implements RecipeService {

        @Autowired
        private final RecipeRepository recipeRepository;
        private final UserRepository userRepository;
        private final ModelMapper modelMapper;
        private final ImageRepository imageRepository;

        public RecipeServiceImpl(RecipeRepository recipeRepository, UserRepository userRepository,
                        ModelMapper modelMapper, ImageRepository imageRepository) {
                this.recipeRepository = recipeRepository;
                this.userRepository = userRepository;
                this.modelMapper = modelMapper;
                this.imageRepository = imageRepository;
        }
        @Override
        public Recipe createRecipe(CreateRecipeRequest request) {
                if (request == null || request.getUser() == null) {
                        throw new IllegalArgumentException("Invalid request or user.");
                }
                User user = Optional.ofNullable(userRepository.findByUsername(request.getUser().getUsername())).map(existingUser -> {
                        if (existingUser.getRecipes() == null) {
                                existingUser.setRecipes(new HashSet<>()); // Initialize if null
                        }
                        existingUser.getRecipes().add(request.getRecipe());
                        return existingUser;
                }).orElseGet(() -> {
                        User newUser = new User(request.getUser().getUsername());
                        // When creating a new user, the constructor will ensure recipes is initialized
                        userRepository.save(newUser);
                        return newUser;
                });

                Recipe recipe = RecipeService.createRecipe(request, user);
                return recipeRepository.save(recipe);
        }
        @Override
        public Recipe updateRecipe(RecipeUpdateRequest request, String recipeId) {
                Recipe recipe = getRecipeById(recipeId);
                Recipe theRecipe = RecipeService.updateRecipe(recipe, request);
                return recipeRepository.save(theRecipe);
        }

        @Override
        public List<Recipe> getAllRecipes() {
                return recipeRepository.findAll();

        }

        @Override
        public Recipe getRecipeById(String id) {
                return recipeRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Recipe not found with id: " + id));
        }

        @Override
        public void deleteRecipe(String id) {
                recipeRepository.deleteById(id);
        }

        @Override
        public Set<String> getAllRecipesCategories() {
                return recipeRepository.findAll()
                                .stream()
                                .map(Recipe::getCategory).collect(Collectors.toSet());
        }

        @Override
        public Set<String> getAllRecipesCuisine() {
                return recipeRepository.findAll()
                                .stream()
                                .map(Recipe::getCuisine).collect(Collectors.toSet());
        }

        @Override
        public RecipeDto converToDto(Recipe recipe) {
                RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);
                UserDto userDto = modelMapper.map(recipe.getUser(), UserDto.class);

                Optional<Image> image = Optional.ofNullable(imageRepository.findByRecipeId(recipe.getId()));
                image.map(img -> modelMapper.map(img, ImageDto.class)).ifPresent(recipeDto::setImageDto);

                double averageReviews = recipe.calculateAverageRating();
                int totalRevoreCount = recipe.getTotalRateCount();
                recipeDto.setTotalRateCount(totalRevoreCount);
                recipeDto.setAvarageRating(averageReviews);


                recipeDto.setUser(userDto);
                return recipeDto;
        }

        @Override
        public List<RecipeDto> convertToDtoList(List<Recipe> recipes) {
                return recipes.stream().map(this::converToDto)
                                .collect(Collectors.toList());
        }

}