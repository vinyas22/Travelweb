package com.proj.train;

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
public class TrainController {
	
	@Autowired
	TrainService service;
	

	@GetMapping("/trainss")
	public List<Trainmodel> gettrain(){
		List<Trainmodel> train= service.gettrain();
		return train;
	}
	
	@RequestMapping (value ="/posttrain", method = RequestMethod.POST
			, consumes = MediaType.APPLICATION_JSON_VALUE)	
	public String posttrain(@RequestBody Trainmodel train) {
		String StatusMessage;
		List<Trainmodel> mod=service.gettrain();
		boolean status=service.posttrain(train);
		if(status) {
			StatusMessage="train data entered successfully";
		}else {
			StatusMessage= "Error while entering train Data";
		}
		return StatusMessage;
	}
	
	@PostMapping(value="/search",
			consumes=MediaType.APPLICATION_JSON_VALUE)
			public List<Trainmodel> postUserData(@RequestBody Trainmodel country) {  
				
			 
			  List<Trainmodel> status=service.getCountryDetailsFromDao(country);
			return status;
	
				
			}

}
