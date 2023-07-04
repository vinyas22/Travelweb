package com.proj.flight;

import java.sql.Time;

public class Flightmodel {
	
	int id;
	String flight_name, flight_code, source, destination, stops;
	Time departure, arrival;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlight_name() {
		return flight_name;
	}
	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}
	public String getFlight_code() {
		return flight_code;
	}
	public void setFlight_code(String flight_code) {
		this.flight_code = flight_code;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStops() {
		return stops;
	}
	public void setStops(String stops) {
		this.stops = stops;
	}
	public Time getDeparture() {
		return departure;
	}
	public void setDeparture(Time departure) {
		this.departure = departure;
	}
	public Time getArrival() {
		return arrival;
	}
	public void setArrival(Time arrival) {
		this.arrival = arrival;
	}
	
	

}
