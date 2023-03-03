package com.example.controllers;


import com.example.entities.Flight;
import com.example.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class FlightController {
	
	private final FlightService flightService;
	
	// Listado de vuelos
	@GetMapping("flights") // URL
	public String findAll(Model model) {
		model.addAttribute("mensaje1", "Hola mundo");
		model.addAttribute("mensaje2", "Hola mundo");
		model.addAttribute("flights", flightService.findAll()); // HTML
		return "flight/flight-list"; // vista
	}
	
	// Detalle de un vuelo concreto por id
	@GetMapping("flights/{id}")
	public String findById(Model model, @PathVariable Long id) {
		Optional<Flight> flightOptional = flightService.findById(id);
		if (flightOptional.isPresent())
			model.addAttribute("flight", flightOptional.get());
		else
			model.addAttribute("error", "Not Found");
		
		return "flight/flight-detail"; // vista
	}
	
	// Mostrar formulario para crear UN (1) nuevo vuelo
	@GetMapping("flights/create")
	public String showCreateForm(Model model) {
		model.addAttribute("flight", new Flight());
		return "flight/flight-form";
	}
	
	// Guardar formulario para crear/editar un vuelo
	@PostMapping("flights")
	public String saveForm(@ModelAttribute Flight flight) {
		flightService.save(flight);
		return "redirect:/flights"; // redirección a controlador findAll
	}
	
	// Mostrar formulario para editar
	@GetMapping("flights/{id}/edit")
	public String showEditForm(Model model, @PathVariable Long id) {
		Optional<Flight> flightOptional = flightService.findById(id);
		if (flightOptional.isPresent())
			model.addAttribute("flight", flightOptional.get());
		else
			model.addAttribute("error", "Not Found");
		
		return "flight/flight-form"; // vista
	}
	
	@GetMapping("flights/{id}/delete")
	public String deleteById(@PathVariable Long id) {
		flightService.deleteById(id);
		return "redirect:/flights";
	}
}
