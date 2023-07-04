package com.proj.flightbooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FlightBookingController {

	@Autowired
	FlightBookingService service;
	
	@GetMapping("/Flights")
	public List<FlightBookingmodel> getFlight(){
		List<FlightBookingmodel> Flight= service.getFlight();
		return Flight;
	}
	
	@RequestMapping (value ="/postFlightbooking", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String postFlight(@RequestBody FlightBookingmodel Flight) {
		String StatusMessage;
		List<FlightBookingmodel> mod=service.getFlight();
		boolean status=service.postFlight(Flight);
		if(status) {
			StatusMessage="Flight data entered successfully";
		}else {
			StatusMessage= "Error while entering Flight Data";
		}
		return StatusMessage;
	}
}
