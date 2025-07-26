package com.example.whik.repository;

import static com.example.whik.entity.QDestination.*;

import java.util.List;

import com.example.whik.entity.Destination;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DestinationCustomRepositoryImpl implements DestinationCustomRepository{
	private final JPAQueryFactory queryFactory;

	@Override
	public List<Destination> searchDestinations(String keyword) {
		return queryFactory
			.selectFrom(destination)
			.where(eqKeyword(keyword))
			.fetch();
	}
	private BooleanExpression eqKeyword(String keyword) {
		return keyword == null ? null : destination.name.containsIgnoreCase(keyword);
	}
}
