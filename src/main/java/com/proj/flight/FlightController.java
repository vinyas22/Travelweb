package com.proj.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class FlightController {
	
	@Autowired
	FlightService service;
	
	@GetMapping("/flights")
	public List<Flightmodel> getflight(){
		List<Flightmodel> mod=service.getflight();
		return mod;
	}
	
	@RequestMapping (value ="/postflight", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String postflight(@RequestBody Flightmodel flight) {
		String StatusMessage;
		List<Flightmodel> mod=service.getflight();
		boolean status=service.postflight(flight);
		if(status) {
			StatusMessage="flight data entered successfully";
		}else {
			StatusMessage= "Error while entering flight Data";
		}
		return StatusMessage;
	}
	
	@PostMapping(value="/searchflight",
			consumes=MediaType.APPLICATION_JSON_VALUE)
			public List<Flightmodel> postUserData(@RequestBody Flightmodel Flightmodel) {  
				
			 
			  List<Flightmodel> status=service.getFlightmodelDetailsFromDao(Flightmodel);
			return status;
			
					  
				
				
			
				
			}

}
