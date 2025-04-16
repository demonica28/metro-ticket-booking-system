package com.metro.ticketing.metro_ticket_booking.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ticket {
	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
//	@Version
//	private int version;

    private String sourceStation;
    private String destinationStation;
    private float price;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expiryTime;

    private boolean entryUsed = false;
    private boolean exitUsed = false;

    public Ticket() {
        this.createdAt = LocalDateTime.now();
        this.expiryTime = createdAt.plusHours(18);  // Ticket expires in 18 hours
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public boolean isEntryUsed() {
		return entryUsed;
	}

	public void setEntryUsed(boolean entryUsed) {
		this.entryUsed = entryUsed;
	}

	public boolean isExitUsed() {
		return exitUsed;
	}

	public void setExitUsed(boolean exitUsed) {
		this.exitUsed = exitUsed;
	}

	
}
