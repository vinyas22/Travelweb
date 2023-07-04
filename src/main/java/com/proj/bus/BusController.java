package com.proj.bus;

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
public class BusController {

	@Autowired
	BusService service;
	
	@GetMapping("/busses")
	public List<Busmodel> getbus(){
		List<Busmodel> bus= service.getbus();
		return bus;
	}
	
	@RequestMapping (value ="/postbus", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String postbus(@RequestBody Busmodel bus) {
		String StatusMessage;
		List<Busmodel> mod=service.getbus();
		boolean status=service.postbus(bus);
		if(status) {
			StatusMessage="Bus data entered successfully";
		}else {
			StatusMessage= "Error while entering Bus Data";
		}
		return StatusMessage;
	}
	
	@PostMapping(value="/searchbus",
			consumes=MediaType.APPLICATION_JSON_VALUE)
			public List<Busmodel> postUserData(@RequestBody Busmodel country) {  
				
			 
			  List<Busmodel> status=service.getCountryDetailsFromDao(country);
			return status;}
	
				
}
