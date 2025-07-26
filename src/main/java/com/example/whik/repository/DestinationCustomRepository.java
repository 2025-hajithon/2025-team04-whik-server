package com.example.whik.repository;

import java.util.List;

import com.example.whik.entity.Destination;

public interface DestinationCustomRepository {
	List<Destination> searchDestinations(String keyword);
}
