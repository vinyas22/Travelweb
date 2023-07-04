package com.proj.hotelbooking;

public class HotelBookingmodel {

	int id;
	String  name, phone, hotel_name, days, sharing, price, Chekin_date, Checkout_date;
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
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getSharing() {
		return sharing;
	}
	public void setSharing(String sharing) {
		this.sharing = sharing;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getChekin_date() {
		return Chekin_date;
	}
	public void setChekin_date(String chekin_date) {
		Chekin_date = chekin_date;
	}
	public String getCheckout_date() {
		return Checkout_date;
	}
	public void setCheckout_date(String checkout_date) {
		Checkout_date = checkout_date;
	}
	
}
