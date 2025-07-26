package com.example.whik.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.whik.dto.DestinationRequest;
import com.example.whik.dto.DestinationResponse;
import com.example.whik.entity.Category;
import com.example.whik.entity.DestinationCategory;
import com.example.whik.entity.ExperienceType;
import com.example.whik.entity.MemberCategory;
import com.example.whik.repository.DestinationCategoryRepository;
import com.example.whik.entity.Destination;
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

	public Double getProbability(Long destinationId, UUID memberId) {
		List<DestinationCategory> destinationCategories = destinationCategoryRepository.findAllByDestinationId(
			destinationId);

		List<MemberCategory> memberCategories = memberCategoryRepository.findAllByMemberId(memberId);
		List<Category> memberCategoriesList = memberCategories.stream()
			.map(MemberCategory::getCategory)
			.toList();

		boolean isFamiliar = destinationCategories.stream()
			.anyMatch(destinationCategory -> memberCategoriesList.contains(destinationCategory.getCategory()));

		if (isFamiliar) {
			long countFamiliarCategories = destinationCategoryRepository.countFamiliarCategories(memberCategoriesList);
			return countFamiliarCategories != 100 ? (double) 100 / countFamiliarCategories : 1.0;
		}
		else {
			long countUnfamiliarCategories = destinationCategoryRepository.countUnfamiliarCategories(memberCategoriesList);
			return countUnfamiliarCategories != 1 ? (double) 100 / countUnfamiliarCategories : 1.0;
		}

	}
}
