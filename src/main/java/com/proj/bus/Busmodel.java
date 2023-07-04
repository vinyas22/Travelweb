package com.proj.bus;

import java.sql.Time;

public class Busmodel {
	int id;
	String bus_name, bus_code, source, destination;
	Time Departure,Arrival;

public Time getDeparture() {
		return Departure;
	}
	public void setDeparture(Time departure) {
		Departure = departure;
	}
	public Time getArrival() {
		return Arrival;
	}
	public void setArrival(Time arrival) {
		Arrival = arrival;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBus_name() {
		return bus_name;
	}
	public void setBus_name(String bus_name) {
		this.bus_name = bus_name;
	}
	public String getBus_code() {
		return bus_code;
	}
	public void setBus_code(String bus_code) {
		this.bus_code = bus_code;
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

	

}
