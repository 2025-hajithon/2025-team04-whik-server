package com.example.whik.dto;

import com.example.whik.entity.Category;

public record CategoryResponse(Category category, String value) {

	public static CategoryResponse from(Category category) {
		return new CategoryResponse(category, category.getValue());
	}
}
