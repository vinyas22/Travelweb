package com.proj.hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.proj.hotel.Hotelmodel;

@Component
public class HotelDao {
	
	@Autowired
	JdbcTemplate template;
	
	public List<Hotelmodel> gethotel(){
		List<Hotelmodel> mod= new ArrayList<>();
		return template.query("select * from proj.hotel",  new ResultSetExtractor<List<Hotelmodel>>() {

			@Override
			public List<Hotelmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					Hotelmodel hotel=new Hotelmodel();
					hotel.setId(rs.getInt("id"));
					hotel.setHotel_name(rs.getString("hotel_name"));
					hotel.setHotel_image(rs.getString("hotel_image"));
					hotel.setLocation(rs.getString("location"));
					hotel.setAc(rs.getString("ac"));
					hotel.setWifi(rs.getString("wifi"));
					mod.add(hotel);
				}
				return mod;
			}
			
		});
	}
	
	public boolean postHotel(Hotelmodel Hotel) {
		boolean status = false;
		String sql= "insert into proj.Hotel(id, Hotel_name, Hotel_code, source, destination, departure, arrival)"
				+"values("+Hotel.getId()+",'"+Hotel.getHotel_name()+"',"+"'"+Hotel.getHotel_image()+"',"+"'"+Hotel.getLocation()
+"',"+"'"+Hotel.getAc()+"',"+"'"+Hotel.getWifi()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
	
	public List<Hotelmodel> getHotelmodelDetailsFromDbtest(Hotelmodel Hotelmodel) {
    	List<Hotelmodel> HotelmodelList = new ArrayList<>();
    	return template.query("SELECT * FROM proj.hotel  WHERE location LIKE"+"'"+Hotelmodel.getLocation()+"%'"
    	,  new ResultSetExtractor<List<Hotelmodel>>(){

    		@Override
			public List<Hotelmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Hotelmodel hotel=new Hotelmodel();
					hotel.setId(rs.getInt("id"));
					hotel.setHotel_name(rs.getString("hotel_name"));
					hotel.setHotel_image(rs.getString("hotel_image"));
					hotel.setLocation(rs.getString("location"));
					hotel.setAc(rs.getString("ac"));
					hotel.setWifi(rs.getString("wifi"));
					
					
					HotelmodelList.add(hotel);
					
				}
				return HotelmodelList;
			}
    		
    		
    	});
    }
	

}
