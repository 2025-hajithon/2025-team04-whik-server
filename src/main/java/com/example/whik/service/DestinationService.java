package com.example.whik.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.whik.dto.DestinationResponse;
import com.example.whik.repository.DestinationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DestinationService {
	private final DestinationRepository destinationRepository;

	@Transactional(readOnly = true)
	public List<DestinationResponse> searchDestinations(String keyword) {
		return destinationRepository.searchDestinations(keyword)
			.stream()
			.map(DestinationResponse::from)
			.toList();
	}
}
