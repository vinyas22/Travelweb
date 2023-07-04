package com.proj.flight;

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
public class FlightDao {

	@Autowired
	JdbcTemplate template;
	
	public List<Flightmodel> getflight(){
		List<Flightmodel> mod= new ArrayList<>();
		return template.query("select * from proj.flight",  new ResultSetExtractor<List<Flightmodel>>() {

			@Override
			public List<Flightmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					Flightmodel flight=new Flightmodel();
					flight.setId(rs.getInt("id"));
					flight.setFlight_name(rs.getString("flight_name"));
					flight.setFlight_code(rs.getString("flight_code"));
					flight.setSource(rs.getString("source"));
					flight.setDestination(rs.getString("destination"));
					flight.setDeparture(rs.getTime("departure"));
					flight.setArrival(rs.getTime("arrival"));
					flight.setStops(rs.getString("stops"));
					mod.add(flight);
				}
				return mod;
			}
			
		});
	}
	
	public boolean postflight(Flightmodel flight) {
		boolean status = false;
		String sql= "insert into proj.flight(id, flight_name, flight_code, source, destination,stops, departure, arrival)"
				+"values("+flight.getId()+",'"+flight.getFlight_name()+"',"+"'"+flight.getFlight_code()+"',"+"'"+flight.getSource()
+"',"+"'"+flight.getDestination()+"',"+"'"+flight.getStops()+"',"+"'"+flight.getDeparture()+"'"+","+"'"+flight.getArrival()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
	public List<Flightmodel> getFlightmodelDetailsFromDbtest(Flightmodel Flightmodel) {
    	List<Flightmodel> FlightmodelList = new ArrayList<>();
    	return template.query("SELECT * FROM proj.flight  WHERE source LIKE"+"'"+Flightmodel.getSource()+"%'"+"and destination like"
    	    	+"'"+Flightmodel.getDestination()
    	    	+"%'"
    			,  new ResultSetExtractor<List<Flightmodel>>(){

    		@Override
			public List<Flightmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Flightmodel flight=new Flightmodel();
					flight.setId(rs.getInt("id"));
					flight.setFlight_name(rs.getString("flight_name"));
					flight.setFlight_code(rs.getString("flight_code"));
					flight.setSource(rs.getString("source"));
					flight.setDestination(rs.getString("destination"));
					flight.setDeparture(rs.getTime("departure"));
					flight.setArrival(rs.getTime("arrival"));
					flight.setStops(rs.getString("stops"));
					
					FlightmodelList.add(flight);
					
				}
				return FlightmodelList;
			}
    		
    		
    	});
    }
	
}
