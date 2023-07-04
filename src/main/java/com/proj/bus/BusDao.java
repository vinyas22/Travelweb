package com.proj.bus;

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
public class BusDao {

	@Autowired
	JdbcTemplate template;
	
	public List<Busmodel> getbus(){
		List<Busmodel> mod= new ArrayList<>();
		return template.query("select * from proj.bus",  new ResultSetExtractor<List<Busmodel>>() {

			@Override
			public List<Busmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					Busmodel bus=new Busmodel();
					bus.setId(rs.getInt("id"));
					bus.setBus_name(rs.getString("bus_name"));
					bus.setBus_code(rs.getString("bus_code"));
					bus.setSource(rs.getString("source"));
					bus.setDestination(rs.getString("destination"));
					bus.setDeparture(rs.getTime("departure"));
					bus.setArrival(rs.getTime("arrival"));
					mod.add(bus);
				}
				return mod;
			}
			
		});
	}
	
	public boolean postbus(Busmodel bus) {
		boolean status = false;
		String sql= "insert into proj.bus(id, bus_name, bus_code, source, destination, departure, arrival)"
				+"values("+bus.getId()+",'"+bus.getBus_name()+"',"+"'"+bus.getBus_code()+"',"+"'"+bus.getSource()
+"',"+"'"+bus.getDestination()+"',"+"'"+bus.getDeparture()+"'"+","+"'"+bus.getArrival()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
	
	public List<Busmodel> getBusmodelDetailsFromDbtest(Busmodel Busmodel) {
    	List<Busmodel> BusmodelList = new ArrayList<>();
    	return template.query("SELECT * FROM proj.Bus  WHERE source LIKE"+"'"+Busmodel.getSource()+"%'"+"and destination like"
    	+"'"+Busmodel.getDestination()
    	+"%'",  new ResultSetExtractor<List<Busmodel>>(){

    		@Override
			public List<Busmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Busmodel Bus=new Busmodel();
					Bus.setId(rs.getInt("id"));
					Bus.setBus_code(rs.getString("Bus_name"));
					Bus.setBus_name(rs.getString("Bus_code"));
					Bus.setSource(rs.getString("source"));
					Bus.setDestination(rs.getString("destination"));
					Bus.setDeparture(rs.getTime("departure"));
					Bus.setArrival(rs.getTime("arrival"));
					
					
					BusmodelList.add(Bus);
					
				}
				return BusmodelList;
			}
    		
    		
    	});
    }
	
}
