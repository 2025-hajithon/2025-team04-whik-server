package com.example.whik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.whik.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination,Long>, DestinationCustomRepository {
}
