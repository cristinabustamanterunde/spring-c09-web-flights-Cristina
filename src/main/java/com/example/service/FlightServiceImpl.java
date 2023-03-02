package com.example.service;

import com.example.entities.Flight;
import com.example.repositoires.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@AllArgsConstructor
@Service
public class FlightServiceImpl implements FlightService {
	
	private final FlightRepository flightRepository;
	
	
	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}
	
	@Override
	public Optional<Flight> findById(Long id) {
		return flightRepository.findById(id); //variable
	}
	
	@Override
	public List<Flight> findAllByAirportFrom(String airport) {
		return flightRepository.findAllByAirportFrom(airport);
	}
	
	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}
	
	@Override
	public void deleteById(Long id) {
		flightRepository.deleteById(id);
	}
}
