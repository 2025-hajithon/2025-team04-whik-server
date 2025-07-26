package com.example.whik.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.whik.dto.DestinationRequest;
import com.example.whik.dto.DestinationResponse;
import com.example.whik.entity.Category;
import com.example.whik.entity.DestinationCategory;
import com.example.whik.entity.ExperienceType;
import com.example.whik.entity.MemberCategory;
import com.example.whik.repository.DestinationCategoryRepository;
import com.example.whik.repository.DestinationRepository;
import com.example.whik.repository.MemberCategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DestinationService {
	private final DestinationRepository destinationRepository;
	private final MemberCategoryRepository memberCategoryRepository;
	private final DestinationCategoryRepository destinationCategoryRepository;

	@Transactional(readOnly = true)
	public DestinationResponse getRandomDestination(DestinationRequest request) {
		List<Category> categories = memberCategoryRepository.findAllByMemberId(request.memberId())
			.stream()
			.map(MemberCategory::getCategory)
			.toList();

		if (request.experienceType() == ExperienceType.FAMILIAR) {
			DestinationCategory destinationCategory = destinationCategoryRepository.findAllByCategories(categories);

			return DestinationResponse.from(destinationCategory.getDestination());
		}
		else {
			DestinationCategory unfamiliarByCategories = destinationCategoryRepository.findUnfamiliarByCategories(
				categories);

			return DestinationResponse.from(unfamiliarByCategories.getDestination());
		}
	}

	@Transactional(readOnly = true)
	public List<DestinationResponse> searchDestinations(String keyword) {
		return destinationRepository.searchDestinations(keyword)
			.stream()
			.map(DestinationResponse::from)
			.toList();
	}

}
