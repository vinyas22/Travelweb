package com.proj.busbooking;

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
public class BusBookingController {
	@Autowired
	BusBookingService service;
	
	@GetMapping("/Buss")
	public List<BusBookingmodel> getBus(){
		List<BusBookingmodel> Bus= service.getBus();
		return Bus;
	}
	
	@RequestMapping (value ="/postBusbooking", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String postBus(@RequestBody BusBookingmodel Bus) {
		String StatusMessage;
		List<BusBookingmodel> mod=service.getBus();
		boolean status=service.postBus(Bus);
		if(status) {
			StatusMessage="Bus data entered successfully";
		}else {
			StatusMessage= "Error while entering Bus Data";
		}
		return StatusMessage;
	}
	
	

}
