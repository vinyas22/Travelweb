package com.proj.hotelbooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelBookingService {

	@Autowired
	HotelBookingDao dao;
	
	public List<HotelBookingmodel> getHotel(){
		List<HotelBookingmodel> Hotel= dao.getHotel();
		return Hotel;
	}

	public boolean postHotel(HotelBookingmodel Hotel) {
		return dao.postHotel(Hotel);
	}
}
