package com.example.whik.repository;

import java.util.List;

import com.example.whik.entity.Category;
import com.example.whik.entity.DestinationCategory;

public interface DestinationCategoryCustomRepository {
	DestinationCategory findAllByCategories(List<Category> categories);

	DestinationCategory findUnfamiliarByCategories(List<Category> categories);

	long countFamiliarCategories(List<Category> categories);

	long countUnfamiliarCategories(List<Category> categories);
}
