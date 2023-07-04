package com.proj.hotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
	
	@Autowired
	HotelDao dao;
	
	public List<Hotelmodel> gethotel(){
		List<Hotelmodel> hotel=dao.gethotel();
		return hotel;
	}

	public boolean postHOtel(Hotelmodel model) {
		return dao.postHotel(model);
	}
	
	public List<Hotelmodel> getHotelmodelDetailsFromDao(Hotelmodel Hotelmodel){
//		List<Hotelmodel> info=Hotelmodeldao.getHotelmodelDetailsFromDbtest(Hotelmodel);
//		List<Hotelmodel> filterlist=info.stream().filter(doct->doct.getHotelmodel_name().equals(Hotelmodel_name)).collect(Collectors.toList());
		return dao.getHotelmodelDetailsFromDbtest(Hotelmodel);
	}
}
