package com.proj.flightbooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightBookingService {

	@Autowired
	FlightBookingDao dao;
	

	public List<FlightBookingmodel> getFlight(){
		List<FlightBookingmodel> Flight= dao.getFlight();
		return Flight;
	}

	public boolean postFlight(FlightBookingmodel Flight) {
		return dao.postFlight(Flight);
	}
}
