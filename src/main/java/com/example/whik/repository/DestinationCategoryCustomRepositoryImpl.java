package com.example.whik.repository;

import static com.example.whik.entity.QDestinationCategory.*;

import java.util.List;

import com.example.whik.entity.Category;
import com.example.whik.entity.DestinationCategory;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DestinationCategoryCustomRepositoryImpl implements DestinationCategoryCustomRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public DestinationCategory findAllByCategories(List<Category> categories) {
		return queryFactory
			.selectFrom(destinationCategory)
			.where(destinationCategory.category.in(categories)			)
			.fetchFirst();
	}

	@Override
	public DestinationCategory findUnfamiliarByCategories(List<Category> categories) {
		return queryFactory
			.selectFrom(destinationCategory)
			.where(destinationCategory.category.notIn(categories)			)
			.fetchFirst();
	}

	@Override
	public long countFamiliarCategories(List<Category> categories) {
		return queryFactory
			.select(destinationCategory.count()).from(destinationCategory)
			.where(destinationCategory.category.in(categories))
			.fetchFirst();
	}

	@Override
	public long countUnfamiliarCategories(List<Category> categories) {
		return queryFactory
			.select(destinationCategory.count()).from(destinationCategory)
			.where(destinationCategory.category.notIn(categories))
			.fetchFirst();
	}
}
