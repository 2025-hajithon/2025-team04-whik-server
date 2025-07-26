package com.example.whik.dto;

import com.example.whik.entity.Destination;

import java.util.List;

public record WishlistResponse(
        Long destinationId, String destinationName, List<String> categories, String description) {
	public static WishlistResponse of(Destination destination, List<String> categories) {
		return new WishlistResponse(
			destination.getId(),
			destination.getName(),
			categories,
			destination.getDescription()
		);
	}
}
