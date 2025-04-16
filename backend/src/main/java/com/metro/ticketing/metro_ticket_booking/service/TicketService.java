package com.metro.ticketing.metro_ticket_booking.service;

import java.time.LocalDateTime;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.metro.ticketing.metro_ticket_booking.model.Ticket;
import com.metro.ticketing.metro_ticket_booking.repository.TicketRepository;

import java.time.Duration;

@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	
	public Ticket bookTicket(String startStation, String endStation, float fare) {
		Ticket ticket = new Ticket();
		//ticket.setId(UUID.randomUUID());
        ticket.setSourceStation(startStation);
        ticket.setDestinationStation(endStation);
        ticket.setPrice(fare);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setExpiryTime(LocalDateTime.now().plusHours(18));
        ticket.setEntryUsed(false);
        ticket.setExitUsed(false);

        return ticketRepository.save(ticket);
	}
	
	public Optional<Ticket> getTicket(UUID ticketId) {
        return ticketRepository.findById(ticketId);
    }

	public ResponseEntity<String> validateAndUseTicket(UUID ticketId, String action) {
	    Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);

	    if (optionalTicket.isEmpty()) return ResponseEntity.badRequest().body("Invalid Ticket");

	    Ticket ticket = optionalTicket.get();

	    // Check expiry (18 hours)
	    if (Duration.between(ticket.getCreatedAt(), LocalDateTime.now()).toHours() >= 18) {
	        return ResponseEntity.badRequest().body("Ticket expired");
	    }

	    if ("entry".equalsIgnoreCase(action)) {
	        if (ticket.isEntryUsed()) return ResponseEntity.badRequest().body("Entry already used");
	        ticket.setEntryUsed(true);
	        ticketRepository.save(ticket);
	        return ResponseEntity.ok("Entry successful");
	    } else if ("exit".equalsIgnoreCase(action)) {
	        if (!ticket.isEntryUsed()) return ResponseEntity.badRequest().body("Cannot exit without entry");
	        if (ticket.isExitUsed()) return ResponseEntity.badRequest().body("Exit already used");
	        ticket.setExitUsed(true);
	        ticketRepository.save(ticket);
	        return ResponseEntity.ok("Exit successful");
	    }

	    return ResponseEntity.badRequest().body("Invalid action");
	}

	
	
}
