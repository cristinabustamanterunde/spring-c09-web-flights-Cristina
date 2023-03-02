package com.example;

import com.example.entities.Flight;
import com.example.repositoires.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class App {

	public static void main (String[] args) {
		var context = SpringApplication.run(App.class, args);
		
		var flightRepo = context.getBean(FlightRepository.class);
		
		Flight f1 = new Flight(null,
				"AIRBUS 7000",
				"MAD",
				"HUG",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				200);
		
		Flight f2 = new Flight(null,
				"AIRBUS 7000",
				"MAD",
				"HUG",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				200);
		
		Flight f3 = new Flight(null,
				"AIRBUS 7000",
				"MAD",
				"HUG",
				LocalDateTime.now().plusDays(1),
				LocalDateTime.now().plusDays(1).plusHours(3),
				200);
		
		flightRepo.saveAll(List.of(f1, f2, f3));
	}

}
