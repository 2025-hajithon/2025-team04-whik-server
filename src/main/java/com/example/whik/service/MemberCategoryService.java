package com.example.whik.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.whik.dto.MemberCategoryRequest;
import com.example.whik.entity.Category;
import com.example.whik.entity.Member;
import com.example.whik.entity.MemberCategory;
import com.example.whik.repository.MemberCategoryRepository;
import com.example.whik.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberCategoryService {

	private final MemberCategoryRepository memberCategoryRepository;
	private final MemberRepository memberRepository;

	@Transactional
	public void createMemberCategory(MemberCategoryRequest request) {
		Member member = memberRepository.findById(request.memberId())
			.orElseThrow(() -> new IllegalArgumentException("member not found"));

		List<Category> categories = request.categories();
		categories.forEach(category ->
				memberCategoryRepository.save(MemberCategory.create(member, category)));
	}
}
