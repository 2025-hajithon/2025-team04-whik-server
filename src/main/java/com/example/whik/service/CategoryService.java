package com.example.whik.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.whik.dto.CategoryResponse;
import com.example.whik.entity.Category;

@Service
public class CategoryService {

	public List<CategoryResponse> getCategories() {
		return Arrays.stream(Category.values())
			.map(CategoryResponse::from)
			.toList();
	}

}
