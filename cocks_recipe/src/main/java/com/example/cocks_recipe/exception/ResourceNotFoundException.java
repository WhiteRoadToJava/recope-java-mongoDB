package com.example.cocks_recipe.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // You might add constructors for specific ID or resource type
    public ResourceNotFoundException(String resourceName, String id) {
        super(String.format("%s with ID %s not found", resourceName, id));
    }
}
