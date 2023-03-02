package com.example.repositoires;

import com.example.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	List<Flight> findAllByAirportFrom(String airport);
}