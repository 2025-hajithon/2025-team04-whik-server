package com.example.whik.dto;

import java.util.List;
import java.util.UUID;

import com.example.whik.entity.Category;

public record MemberCategoryRequest(UUID memberId, List<Category> categories) {
}
