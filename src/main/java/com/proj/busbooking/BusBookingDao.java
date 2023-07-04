package com.proj.busbooking;

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
public class BusBookingDao {
	
	@Autowired
	JdbcTemplate template;
	
	public List<BusBookingmodel> getBus(){
		List<BusBookingmodel> mod= new ArrayList<>();
		return template.query("select * from proj.busbooking_details",  new ResultSetExtractor<List<BusBookingmodel>>() {

			@Override
			public List<BusBookingmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					BusBookingmodel Bus=new BusBookingmodel();
					Bus.setId(rs.getInt("id"));
					Bus.setName(rs.getString("name"));
					Bus.setPhone(rs.getString("phone"));
					Bus.setPrice(rs.getString("price"));
					Bus.setSeat_no(rs.getString("seat_no"));
					Bus.setDatee(rs.getString("datee"));

					Bus.setBus_name(rs.getString("Bus_name"));
					Bus.setSource(rs.getString("source"));
					Bus.setDestination(rs.getString("destination"));
					Bus.setDeparture(rs.getTime("departure"));
					Bus.setArrival(rs.getTime("arrival"));
					mod.add(Bus);
				}
				return mod;
			}
			
		});
	}
	
	public boolean postBus(BusBookingmodel Bus) {
		boolean status = false;
		String sql= "insert into proj.Busbooking_details(id, name,phone,Bus_name, seat_no,price, source, destination, departure, arrival,datee)"
				+"values("+Bus.getId()+",'"+Bus.getName()+"',"+"'"+Bus.getPhone()+"',"+"'"+Bus.getBus_name()+"',"+"'"+
				Bus.getSeat_no()+"',"+"'"+Bus.getPrice()+"',"+"'"+Bus.getSource()
+"',"+"'"+Bus.getDestination()+"',"+"'"+Bus.getDeparture()+"'"+","+"'"+Bus.getArrival()+"',"+"'"+Bus.getDatee()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
	
	

}
