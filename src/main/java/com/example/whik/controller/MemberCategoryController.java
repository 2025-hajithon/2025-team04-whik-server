package com.example.whik.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.whik.dto.MemberCategoryRequest;
import com.example.whik.service.MemberCategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "MemberCategory")
@RestController
@RequestMapping("/member-categories")
@RequiredArgsConstructor
public class MemberCategoryController {

	private final MemberCategoryService memberCategoryService;

	@PostMapping
	public ResponseEntity<Void> createMemberCategory(@RequestBody MemberCategoryRequest request) {
		memberCategoryService.createMemberCategory(request);
		return ResponseEntity.ok().build();
	}

}
