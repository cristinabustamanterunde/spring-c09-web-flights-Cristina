package com.example.service;

import com.example.entities.Flight;

import java.util.List;
import java.util.Optional;


public interface FlightService {
	
	List<Flight> findAll();
	Optional<Flight> findById(Long id);
	List<Flight> findAllByAirportFrom(String airport);
	
	Flight save(Flight flight);
	void deleteById(Long id);
	
	
	
	
}
