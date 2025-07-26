package com.example.whik.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExperienceType {
	FAMILIAR("익숙한"),
	UNUSUAL("색다른");

	private final String description;
}
