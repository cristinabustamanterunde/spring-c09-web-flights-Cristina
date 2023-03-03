package com.example;

import com.example.entities.Flight;
import com.example.entities.Ticket;
import com.example.repositories.FlightRepository;
import com.example.repositories.TicketRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		var context = SpringApplication.run(App.class, args);
		
		var flightRepo = context.getBean(FlightRepository.class);
		
		Flight f1 = new Flight(null,
				"AIRBUS 7000",
				"MAD",
				"HUG",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				200, null);
		
		Flight f2 = new Flight(null,
				"AIRBUS 7000",
				"MAD",
				"HUG",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				200, null);
		
		Flight f3 = new Flight(null,
				"AIRBUS 7000",
				"MAD",
				"HUG",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				200, null);
		
		flightRepo.saveAll(List.of(f1, f2, f3));
		
		var ticketRepo = context.getBean(TicketRepository.class);
		Ticket t1 = new Ticket(null, "A1", 58.8, false, f1);
		Ticket t2 = new Ticket(null, "A2", 58.8, false, f1);
		Ticket t3 = new Ticket(null, "A3", 58.8, false, f1);
		Ticket t4 = new Ticket(null, "B1", 58.8, false, f2);
		ticketRepo.saveAll(List.of(t1, t2, t3, t4));
		
	}
}
