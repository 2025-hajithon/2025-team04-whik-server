package com.example.whik.dto;

import java.util.UUID;

public record WishlistRequest(UUID memberId, Long destinationId) {
}
