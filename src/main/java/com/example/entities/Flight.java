package com.example.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String plane;
	private String airportFrom;
	private String airportTo;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime dateTimeFrom; // departure
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime dateTimeTo; // arrival
	private Integer seats;
	
}