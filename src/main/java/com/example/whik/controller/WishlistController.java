package com.example.whik.controller;

import com.example.whik.dto.WishlistRequest;
import com.example.whik.dto.WishlistResponse;
import com.example.whik.entity.Wishlist;
import com.example.whik.service.WishlistService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    public ResponseEntity<WishlistResponse> findAllWishlists(
            @RequestParam UUID memberId
            ) {
        List<WishlistResponse> responses = wishlistService.findAllByMemberId(memberId);
        return ResponseEntity.ok().build();
    }
}
