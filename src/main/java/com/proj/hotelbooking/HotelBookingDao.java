package com.proj.hotelbooking;

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
public class HotelBookingDao {

	@Autowired
	JdbcTemplate template;
	

	public List<HotelBookingmodel> getHotel(){
		List<HotelBookingmodel> mod= new ArrayList<>();
		return template.query("select * from proj.hotelbooking_details",  new ResultSetExtractor<List<HotelBookingmodel>>() {

			@Override
			public List<HotelBookingmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					HotelBookingmodel Hotel=new HotelBookingmodel();
					Hotel.setId(rs.getInt("id"));
					Hotel.setName(rs.getString("name"));
					Hotel.setPhone(rs.getString("phone"));
					Hotel.setPrice(rs.getString("price"));
					Hotel.setDays(rs.getString("days"));
					Hotel.setSharing(rs.getString("sharing"));
					Hotel.setChekin_date(rs.getString("Chekin_date"));
					Hotel.setHotel_name(rs.getString("Hotel_name"));
					Hotel.setChekin_date(rs.getString("Checkout_date"));
					
					mod.add(Hotel);
				}
				return mod;
			}
			
		});
	}
	
	
	public boolean postHotel(HotelBookingmodel Hotel) {
		boolean status = false;
		String sql= "insert into proj.hotelbooking_details( name,phone,Hotel_name, price,sharing,days,chekin_date,checkout_date)"
				+"values("+"'"+Hotel.getName()+"',"+"'"+Hotel.getPhone()+"',"+"'"+Hotel.getHotel_name()+"',"+"'"+
				Hotel.getDays()+"',"+"'"+Hotel.getPrice()+"',"+"'"+Hotel.getSharing()
+"',"+"'"+Hotel.getChekin_date()+"',"+"'"+Hotel.getCheckout_date()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
}
