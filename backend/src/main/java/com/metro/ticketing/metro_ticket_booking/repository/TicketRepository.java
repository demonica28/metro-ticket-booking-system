package com.metro.ticketing.metro_ticket_booking.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.ticketing.metro_ticket_booking.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, UUID>{

}
