package com.proj.busbooking;

import java.sql.Time;

public class BusBookingmodel {
	int id;
	String name, phone, Bus_name, source, destination, seat_no, price,datee;
	public String getDatee() {
		return datee;
	}
	public void setDatee(String datee) {
		this.datee = datee;
	}
	Time departure, arrival;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBus_name() {
		return Bus_name;
	}
	public void setBus_name(String Bus_name) {
		this.Bus_name = Bus_name;
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
	public String getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
