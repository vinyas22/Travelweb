package com.proj.train;

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
public class TrainDao {
	
	@Autowired
	JdbcTemplate template;
	
	public List<Trainmodel> gettrain(){
		List<Trainmodel> mod= new ArrayList<>();
		return template.query("select * from proj.train",  new ResultSetExtractor<List<Trainmodel>>() {

			@Override
			public List<Trainmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					Trainmodel train=new Trainmodel();
					train.setId(rs.getInt("id"));
					train.setTrain_code(rs.getString("train_name"));
					train.setTrain_name(rs.getString("train_code"));
					train.setSource(rs.getString("source"));
					train.setDestination(rs.getString("destination"));
					train.setDeparture(rs.getTime("departure"));
					train.setArrival(rs.getTime("arrival"));
					mod.add(train);
				}
				return mod;
			}
			
		});
	}
	
	public boolean posttrain(Trainmodel train) {
		boolean status = false;
		String sql= "insert into proj.train(id, train_name, train_code, source, destination, departure, arrival)"
				+"values("+train.getId()+",'"+train.getTrain_name()+"',"+"'"+train.getTrain_code()+"',"+"'"+train.getSource()
+"',"+"'"+train.getDestination()+"',"+"'"+train.getDeparture()+"'"+","+"'"+train.getArrival()+"'"+")";
		try {
			template.execute(sql);
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return status;
}
	
	public List<Trainmodel> getTrainmodelDetailsFromDbtest(Trainmodel Trainmodel) {
    	List<Trainmodel> TrainmodelList = new ArrayList<>();
    	return template.query("SELECT * FROM proj.train  WHERE source LIKE"+"'"+Trainmodel.getSource()+"%'"+"and destination like"
    	+"'"+Trainmodel.getDestination()
    	+"%'",  new ResultSetExtractor<List<Trainmodel>>(){

    		@Override
			public List<Trainmodel> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()) {
					Trainmodel train=new Trainmodel();
					train.setId(rs.getInt("id"));
					train.setTrain_code(rs.getString("train_name"));
					train.setTrain_name(rs.getString("train_code"));
					train.setSource(rs.getString("source"));
					train.setDestination(rs.getString("destination"));
					train.setDeparture(rs.getTime("departure"));
					train.setArrival(rs.getTime("arrival"));
					
					
					TrainmodelList.add(train);
					
				}
				return TrainmodelList;
			}
    		
    		
    	});
    }

}
