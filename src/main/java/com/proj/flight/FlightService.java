package com.proj.flight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
	
	@Autowired
	FlightDao dao;
	
	public List<Flightmodel> getflight(){
		List<Flightmodel> fli=dao.getflight();
		return fli;
		
	}
	
	public boolean postflight(Flightmodel mod) {
		return dao.postflight(mod);
	}

	public List<Flightmodel> getFlightmodelDetailsFromDao(Flightmodel Flightmodel){
//		List<Flightmodel> info=Flightmodeldao.getFlightmodelDetailsFromDbtest(Flightmodel);
//		List<Flightmodel> filterlist=info.stream().filter(doct->doct.getFlightmodel_name().equals(Flightmodel_name)).collect(Collectors.toList());
		return dao.getFlightmodelDetailsFromDbtest(Flightmodel);
	}

}
