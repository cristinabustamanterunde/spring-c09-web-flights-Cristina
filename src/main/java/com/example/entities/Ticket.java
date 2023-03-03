package com.example.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String seat;
	private Double price;
	private Boolean food;
	
	@ManyToOne
	@ToString.Exclude
	private Flight flight;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Ticket ticket = (Ticket) o;
		return id != null && Objects.equals(id, ticket.id);
	}
	
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	
	
	
}
