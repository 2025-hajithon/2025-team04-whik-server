package com.example.whik.service;

import com.example.whik.entity.Destination;
import com.example.whik.entity.Member;
import com.example.whik.entity.Wishlist;
import com.example.whik.repository.DestinationRepository;
import com.example.whik.repository.MemberRepository;
import com.example.whik.repository.WishlistRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WishlistService {
    private final WishlistRepository wishlistRepository;
    private final DestinationRepository destinationRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void saveDestination(UUID memberId, Long destinationId) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("member not found"));

        Destination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new IllegalArgumentException("Destination not found"));

        Wishlist wishlist = Wishlist.create(member, destination);
        wishlistRepository.save(wishlist);
    }
}
