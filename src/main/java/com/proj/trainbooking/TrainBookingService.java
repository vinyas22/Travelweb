package com.proj.trainbooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrainBookingService {

	@Autowired
	TrainBookingDao dao;
	
	
	public List<TrainBookingmodel> gettrain(){
		List<TrainBookingmodel> train= dao.gettrain();
		return train;
	}

	public boolean posttrain(TrainBookingmodel train) {
		return dao.posttrain(train);
	}
}
