package com.proj.train;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proj.train.TrainDao;


@Service
public class TrainService {


	@Autowired
	TrainDao dao;
	
	public List<Trainmodel> gettrain(){
		List<Trainmodel> train= dao.gettrain();
		return train;
	}

	public boolean posttrain(Trainmodel train) {
		return dao.posttrain(train);
	}
	
	
	public List<Trainmodel> getCountryDetailsFromDao(Trainmodel country){
//		List<Country> info=countrydao.getCountryDetailsFromDbtest(country);
//		List<Country> filterlist=info.stream().filter(doct->doct.getCountry_name().equals(country_name)).collect(Collectors.toList());
		return dao.getTrainmodelDetailsFromDbtest(country);
	}
}
