package com.proj.flightbooking;


public class FlightBookingmodel {
	
	
int	id;
String name, phone, flight_name, source, destination, seat_no, classs, price,datee;
public String getDatee() {
	return datee;
}
public void setDatee(String datee) {
	this.datee = datee;
}
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
public String getFlight_name() {
	return flight_name;
}
public void setFlight_name(String flight_name) {
	this.flight_name = flight_name;
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
public String getClasss() {
	return classs;
}
public void setClasss(String classs) {
	this.classs = classs;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getDeparture() {
	return departure;
}
public void setDeparture(String departure) {
	this.departure = departure;
}
public String getArrival() {
	return arrival;
}
public void setArrival(String arrival) {
	this.arrival = arrival;
}
String departure, arrival;

}
