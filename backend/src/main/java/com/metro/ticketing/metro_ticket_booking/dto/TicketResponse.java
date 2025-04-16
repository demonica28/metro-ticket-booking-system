package com.metro.ticketing.metro_ticket_booking.dto;

import java.util.UUID;

public class TicketResponse {
	
	private UUID ticketId;
    private String sourceStation;
    private String destinationStation;
    private float price;
    private String qrCodeBase64;

    // Constructors
    public TicketResponse() {}

    public TicketResponse(UUID ticketId, String sourceStation, String destinationStation, float price, String qrCodeBase64) {
        this.ticketId = ticketId;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.price = price;
        this.qrCodeBase64 = qrCodeBase64;
    }

    // Getters and Setters
    public UUID getTicketId() {
        return ticketId;
    }

    public void setTicketId(UUID ticketId) {
        this.ticketId = ticketId;
    }

    public String getSourceStation() {
        return sourceStation;
    }

    public void setSourceStation(String sourceStation) {
        this.sourceStation = sourceStation;
    }

    public String getDestinationStation() {
        return destinationStation;
    }

    public void setDestinationStation(String destinationStation) {
        this.destinationStation = destinationStation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getQrCodeBase64() {
        return qrCodeBase64;
    }

    public void setQrCodeBase64(String qrCodeBase64) {
        this.qrCodeBase64 = qrCodeBase64;
    }

}
