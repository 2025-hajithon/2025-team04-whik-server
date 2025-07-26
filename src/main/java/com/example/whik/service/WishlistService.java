package com.example.whik.service;

import com.example.whik.dto.WishlistResponse;
import com.example.whik.entity.Category;
import com.example.whik.entity.Destination;
import com.example.whik.entity.DestinationCategory;
import com.example.whik.entity.Member;
import com.example.whik.entity.Wishlist;
import com.example.whik.repository.DestinationCategoryRepository;
import com.example.whik.repository.DestinationRepository;
import com.example.whik.repository.MemberRepository;
import com.example.whik.repository.WishlistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final DestinationRepository destinationRepository;
    private final DestinationCategoryRepository destinationCategoryRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createWishlist(UUID memberId, Long destinationId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("member not found"));

        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new IllegalArgumentException("Destination not found"));

        Wishlist wishlist = Wishlist.create(member, destination);
        wishlistRepository.save(wishlist);
    }

    @Transactional
    public List<WishlistResponse> findAllByMemberId(UUID memberId) {
        List<Wishlist> wishlists = wishlistRepository.findAllByMemberId(memberId);

        List<WishlistResponse> response = new ArrayList<>();
        wishlists.forEach(wishlist -> {
            List<String> categories = destinationCategoryRepository.findAllByDestinationId(
                    wishlist.getDestination().getId())
                .stream().map(DestinationCategory::getCategory)
                .map(Category::getValue).toList();
            response.add(WishlistResponse.of(wishlist.getDestination(), categories));
        });

        return response;
    }
}
