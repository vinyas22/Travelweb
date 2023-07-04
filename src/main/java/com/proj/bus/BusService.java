package com.proj.bus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusService {
	
	@Autowired
	BusDao dao;
	
	public List<Busmodel> getbus(){
		List<Busmodel> bus= dao.getbus();
		return bus;
	}

	public boolean postbus(Busmodel bus) {
		return dao.postbus(bus);
	}
	public List<Busmodel> getCountryDetailsFromDao(Busmodel country){
//		List<Country> info=countrydao.getCountryDetailsFromDbtest(country);
//		List<Country> filterlist=info.stream().filter(doct->doct.getCountry_name().equals(country_name)).collect(Collectors.toList());
		return dao.getBusmodelDetailsFromDbtest(country);
	}
}
