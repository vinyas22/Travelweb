package com.proj.hotelbooking;

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
public class HotelBookingController {

	@Autowired
	HotelBookingService service;
	
	@GetMapping("/Hotelssb")
	public List<HotelBookingmodel> getHotel(){
		List<HotelBookingmodel> Hotel= service.getHotel();
		return Hotel;
	}
	
	@RequestMapping (value ="/postHotelbooking", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String postHotel(@RequestBody HotelBookingmodel Hotel) {
		String StatusMessage;
		List<HotelBookingmodel> mod=service.getHotel();
		boolean status=service.postHotel(Hotel);
		if(status) {
			StatusMessage="Hotel data entered successfully";
		}else {
			StatusMessage= "Error while entering Hotel Data";
		}
		return StatusMessage;
	}
}
