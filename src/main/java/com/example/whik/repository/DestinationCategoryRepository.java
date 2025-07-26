package com.example.whik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.whik.entity.DestinationCategory;

public interface DestinationCategoryRepository extends JpaRepository<DestinationCategory, Long>, DestinationCategoryCustomRepository {
}
