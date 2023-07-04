package com.proj.busbooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusBookingService {
	
	@Autowired
	BusBookingDao dao;
	
	public List<BusBookingmodel> getBus(){
		List<BusBookingmodel> Bus= dao.getBus();
		return Bus;
	}

	public boolean postBus(BusBookingmodel Bus) {
		return dao.postBus(Bus);
	}

}
