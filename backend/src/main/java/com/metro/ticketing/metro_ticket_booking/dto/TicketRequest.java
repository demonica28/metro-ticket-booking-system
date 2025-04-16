package com.metro.ticketing.metro_ticket_booking.dto;


	public class TicketRequest {
		
		private String sourceStation;
	    private String destinationStation;
	    private float price;

	    // Getters and Setters
	    
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
		
	}


