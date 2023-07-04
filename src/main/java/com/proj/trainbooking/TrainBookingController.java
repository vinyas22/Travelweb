package com.proj.trainbooking;

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
public class TrainBookingController {

	@Autowired
	TrainBookingService service;
	
	@GetMapping("/trains")
	public List<TrainBookingmodel> gettrain(){
		List<TrainBookingmodel> train= service.gettrain();
		return train;
	}
	
	@RequestMapping (value ="/posttrainbooking", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String posttrain(@RequestBody TrainBookingmodel train) {
		String StatusMessage;
		List<TrainBookingmodel> mod=service.gettrain();
		boolean status=service.posttrain(train);
		if(status) {
			StatusMessage="train data entered successfully";
		}else {
			StatusMessage= "Error while entering train Data";
		}
		return StatusMessage;
	}
}
