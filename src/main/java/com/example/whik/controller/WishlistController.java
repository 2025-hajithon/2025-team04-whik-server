package com.example.whik.controller;

import com.example.whik.dto.WishlistRequest;
import com.example.whik.service.WishlistService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Wishlist")
@RestController
@RequestMapping("/wishlists")
@RequiredArgsConstructor
public class WishlistController {
    private final WishlistService wishlistService;

    @PostMapping
    public ResponseEntity<Void> createWishlist(
            @RequestBody WishlistRequest request
    ) {
        wishlistService.createWishlist(request.memberId(), request.destinationId());
        return ResponseEntity.ok().build();
    }
}
