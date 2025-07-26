package com.example.whik.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whik.entity.MemberCategory;

public interface MemberCategoryRepository extends JpaRepository<MemberCategory, Long> {
	List<MemberCategory> findAllByMemberId(UUID memberId);
}
