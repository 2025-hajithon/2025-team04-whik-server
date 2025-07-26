package com.example.whik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whik.entity.MemberCategory;

public interface MemberCategoryRepository extends JpaRepository<MemberCategory, Long> {
}
