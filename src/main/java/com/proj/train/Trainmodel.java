package com.proj.train;

import java.sql.Time;

public class Trainmodel {
	int id;
	String train_name, train_code, source, destination;
	Time departure, arrival;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrain_name() {
		return train_name;
	}
	public void setTrain_name(String train_name) {
		this.train_name = train_name;
	}
	public String getTrain_code() {
		return train_code;
	}
	public void setTrain_code(String train_code) {
		this.train_code = train_code;
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
