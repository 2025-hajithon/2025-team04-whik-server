package com.example.whik.dto;

import com.example.whik.entity.Category;

import java.util.List;

public record WishlistResponse(
        Long destinationId, String destinationName, List<Category> categories, String description) {
}
