package com.example.controllers;
import com.example.entities.Ticket;
import com.example.service.TicketService;
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
public class TicketController {
	
	private final TicketService ticketService;
	
	
	@GetMapping("tickets")
	public String findAll(Model model) {
		model.addAttribute("tickets", ticketService.findAll());
		return "ticket/ticket-list";
	}
	
	@GetMapping("tickets/{id}")
	public String findById(Model model, @PathVariable Long id) {
		Optional<Ticket> ticketOptional = ticketService.findById(id);
		if (ticketOptional.isPresent())
			model.addAttribute("ticket", ticketOptional.get());
		else
			model.addAttribute("error", "Not Found");
		
		return "ticket/ticket-detail"; // vista
	}
	
	@GetMapping("tickets/create")
	public String showCreateForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket/ticket-form";
	}
	// Guardar formulario para crear/editar un vuelo
	@PostMapping("tickets")
	public String saveForm(@ModelAttribute Ticket ticket) {
		ticketService.save(ticket);
		return "redirect:/tickets"; // redirección a controlador findAll
	}
	
	// Mostrar formulario para editar
	@GetMapping("tickets/{id}/edit")
	public String showEditForm(Model model, @PathVariable Long id) {
		Optional<Ticket> ticketOptional = ticketService.findById(id);
		if (ticketOptional.isPresent())
			model.addAttribute("flight", ticketOptional.get());
		else
			model.addAttribute("error", "Not Found");
		
		return "ticket/ticket-form"; // vista
	}
	
	@GetMapping("tickets/{id}/delete")
	public String deleteById(@PathVariable Long id) {
		ticketService.deleteById(id);
		return "redirect:/tickets";
	}
}
