package com.example.whik.dto;

import com.example.whik.entity.Destination;

public record DestinationResponse(String name, String description) {
	public static DestinationResponse from(Destination destination) {
		return new DestinationResponse(destination.getName(), destination.getDescription());
	}
}
