package com.metro.ticketing.metro_ticket_booking.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;
import com.metro.ticketing.metro_ticket_booking.dto.TicketRequest;
import com.metro.ticketing.metro_ticket_booking.dto.TicketResponse;
import com.metro.ticketing.metro_ticket_booking.model.Ticket;
import com.metro.ticketing.metro_ticket_booking.service.QRCodeGeneratorService;
import com.metro.ticketing.metro_ticket_booking.service.TicketService;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:4300") // Allow requests from frontend
public class TicketController {
	
	@Autowired
    private TicketService ticketService;
	
	@Autowired
	private QRCodeGeneratorService qrCodeGeneratorService;
	
	//book a new ticket
//	@PostMapping("/book")
//    public Ticket bookTicket(@RequestParam String sourceStation, 
//                             @RequestParam String destinationStation, 
//                             @RequestParam float price) {
//       return ticketService.bookTicket(sourceStation, destinationStation, price);
//    }
	@PostMapping("/book")
	public ResponseEntity<TicketResponse> bookTicket(@RequestBody TicketRequest request) throws WriterException, IOException {
	    Ticket newTicket =  ticketService.bookTicket(request.getSourceStation(), request.getDestinationStation(), request.getPrice());
	    
	    String qrCode = qrCodeGeneratorService.generateQRCode(newTicket.getId().toString(), 200, 200);
	    
	    TicketResponse response = new TicketResponse(
	            newTicket.getId(),
	            newTicket.getSourceStation(),
	            newTicket.getDestinationStation(),
	            newTicket.getPrice(),
	            qrCode
	    );

	    return ResponseEntity.ok(response);
	}
	
	//️Get ticket details by ID
    @GetMapping("/{ticketId}")
    public Optional<Ticket> getTicket(@PathVariable UUID ticketId) {
        return ticketService.getTicket(ticketId);
    }
    
    //Use ticket for entry/exit
    @PostMapping("/scan")
    public ResponseEntity<String> scanTicket(@RequestParam UUID ticketId, @RequestParam String action) {
        return ticketService.validateAndUseTicket(ticketId, action); // action = "entry" or "exit"
    }


}


