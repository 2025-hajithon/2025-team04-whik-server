package com.example.whik.dto;

import java.util.UUID;

import com.example.whik.entity.ExperienceType;

public record DestinationRequest(UUID memberId, ExperienceType experienceType) {
}
