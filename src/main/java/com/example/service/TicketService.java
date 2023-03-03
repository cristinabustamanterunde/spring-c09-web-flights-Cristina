package com.example.service;

import com.example.entities.Flight;
import com.example.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

	
	List<Ticket> findAll();
	Optional<Ticket> findById(Long id);
	List<Ticket> findAllByAirportFrom(String airport);
	
	Ticket save(Ticket ticket);
	void deleteById(Long id);
}