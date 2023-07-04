package com.proj.flightbooking;

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
public class FlightBookingDao {

	@Autowired
	JdbcTemplate template;
	
	public List<FlightBookingmodel> getFlight(){
		List<FlightBookingmodel> mod= new ArrayList<>();
		return template.query("select * from proj.flightbooking_details",  new ResultSetExtractor<List<FlightBookingmodel>>() {

			@Override
			public List<FlightBookingmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					FlightBookingmodel Flight=new FlightBookingmodel();
					Flight.setId(rs.getInt("id"));
					Flight.setName(rs.getString("name"));
					Flight.setPhone(rs.getString("phone"));
					Flight.setPrice(rs.getString("price"));
					Flight.setSeat_no(rs.getString("seat_no"));
					Flight.setDatee(rs.getString("datee"));
					Flight.setClasss(rs.getString("classs"));
					Flight.setFlight_name(rs.getString("Flight_name"));
					Flight.setSource(rs.getString("source"));
					Flight.setDestination(rs.getString("destination"));
					Flight.setDeparture(rs.getString("departure"));
					Flight.setArrival(rs.getString("arrival"));
					mod.add(Flight);
				}
				return mod;
			}
			
		});
	}
	

	public boolean postFlight(FlightBookingmodel Flight) {
		boolean status = false;
		String sql= "insert into proj.flightbooking_details( name,phone,Flight_name, seat_no,price, source, destination,classs, departure, arrival,datee)"
				+"values("+"'"+Flight.getName()+"',"+"'"+Flight.getPhone()+"',"+"'"+Flight.getFlight_name()+"',"+"'"+
				Flight.getSeat_no()+"',"+"'"+Flight.getPrice()+"',"+"'"+Flight.getSource()
+"',"+"'"+Flight.getClasss()+"',"+"'"+Flight.getDestination()+"',"+"'"+Flight.getDeparture()+"'"+","+"'"+Flight.getArrival()+"',"+"'"+Flight.getDatee()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
}
