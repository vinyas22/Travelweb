package com.proj.hotel;

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
public class HotelController {
	
	@Autowired
	HotelService service;
	

	@GetMapping("/hotels")
	public List<Hotelmodel> gethotel(){
		List<Hotelmodel> hotel= service.gethotel();
		return hotel;
	}
	
	@RequestMapping (value ="/posthotel", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String posthotel(@RequestBody Hotelmodel hotel) {
		String StatusMessage;
		List<Hotelmodel> mod=service.gethotel();
		boolean status=service.postHOtel(hotel);
		if(status) {
			StatusMessage="hotel data entered successfully";
		}else {
			StatusMessage= "Error while entering hotel Data";
		}
		return StatusMessage;
	}
	
	@PostMapping(value="/searchhotel",
			consumes=MediaType.APPLICATION_JSON_VALUE)
			public List<Hotelmodel> postUserData(@RequestBody Hotelmodel Hotelmodel) {  
				
			 
			  List<Hotelmodel> status=service.getHotelmodelDetailsFromDao(Hotelmodel);
			return status;
			
					  
				
				
			
				
			}

}
