package com.example.whik.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.whik.dto.DestinationResponse;
import com.example.whik.service.DestinationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Destination")
@RestController
@RequestMapping("/destinations")
@RequiredArgsConstructor
public class DestinationController {
	private final DestinationService destinationService;

	@GetMapping("/search")
	public ResponseEntity<List<DestinationResponse>> searchDestinations(@RequestParam(name = "destination") String destination) {
		List<DestinationResponse> response = destinationService.searchDestinations(destination);
		return ResponseEntity.ok(response);
	}
}
