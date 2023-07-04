package com.proj.trainbooking;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;



@Component
public class TrainBookingDao {
	
	@Autowired
	JdbcTemplate template;
	
	public List<TrainBookingmodel> gettrain(){
		List<TrainBookingmodel> mod= new ArrayList<>();
		return template.query("select * from proj.trainbooking_details",  new ResultSetExtractor<List<TrainBookingmodel>>() {

			@Override
			public List<TrainBookingmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					TrainBookingmodel train=new TrainBookingmodel();
					train.setId(rs.getInt("id"));
					train.setName(rs.getString("name"));
					train.setPhone(rs.getString("phone"));
					train.setPrice(rs.getString("price"));
					train.setSeat_no(rs.getString("seat_no"));
					train.setDatee(rs.getString("datee"));

					train.setTrain_name(rs.getString("train_name"));
					train.setSource(rs.getString("source"));
					train.setDestination(rs.getString("destination"));
					train.setDeparture(rs.getString("departure"));
					train.setArrival(rs.getString("arrival"));
					mod.add(train);
				}
				return mod;
			}
			
		});
	}
	
	public boolean posttrain(TrainBookingmodel train) {
		boolean status = false;
		String sql= "insert into proj.trainbooking_details( name,phone,train_name, seat_no,price, source, destination, departure, arrival,datee)"
				+"values("+"'"+train.getName()+"',"+"'"+train.getPhone()+"',"+"'"+train.getTrain_name()+"',"+"'"+
				train.getSeat_no()+"',"+"'"+train.getPrice()+"',"+"'"+train.getSource()
+"',"+"'"+train.getDestination()+"',"+"'"+train.getDeparture()+"'"+","+"'"+train.getArrival()+"',"+"'"+train.getDatee()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
	
	

}
