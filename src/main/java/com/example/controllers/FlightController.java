package com.example.controllers;

import com.example.entities.Flight;
import com.example.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class FlightController {
	
	private final FlightService flightService;
	
	@GetMapping("flights") //controlador de uuelos. Es URL
	public String findAll(Model model){  //modelos donde cargan los datos
		
		model.addAttribute("mensaje1","Hola mundo"); //para el HTML (elegir CLAVE y VALOR)
		model.addAttribute("mensaje2","Hola mundo"); //se puede incluir lo que se quiera
		model.addAttribute("flights", flightService.findAll()); // para el HTML
		return "flight/flight-list"; //si hay mucho htmls los agrupamos por subcarpetas. ES LA VISTA.
	}
	
	//Detalle de un vuelo concreto por id
	@GetMapping("flights/{id}")
	public String findById(Model model, @PathVariable Long id) {
		Optional<Flight> flightOptional = flightService.findById(id); //donde cargas datos, es sin @
		if (flightOptional.isPresent())
			model.addAttribute("flight", flightOptional.get());
		else
			model.addAttribute("error", "Not found");
		
		return "flight/flight-detail";
		
	}
	
	
	//Mostrar formulario para nuevo vuelo solo 1
	@GetMapping("flights/create")
	public String showCreateForm(Model model) {
		model.addAttribute("flight", new Flight());
		return "flight/flight-form";
		
		
	}
}
