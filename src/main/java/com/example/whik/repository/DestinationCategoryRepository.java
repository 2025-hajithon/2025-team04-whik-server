package com.example.whik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.whik.entity.DestinationCategory;

public interface DestinationCategoryRepository extends JpaRepository<DestinationCategory, Long>, DestinationCategoryCustomRepository {

	List<DestinationCategory> findAllByDestinationId(Long destinationId);
}
