package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import com.techelevator.model.Weather;


@Component
public class JDBCWeatherDAO implements WeatherDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired  //connecting to the dao 
	public void JdbcParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

    //fetching weather forecast through parkcode using sql statements
	@Override
	public List<Weather> getParkForecast(String parkCode) {
		List<Weather> parkForecast = new ArrayList<>();
		String sqlSelectionParkCode = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectionParkCode, parkCode);
		
		while (results.next()) {  //incrementing the cursor
			parkForecast.add(mapRowToParkForecast(results));
		}
		return parkForecast;
	}

	private Weather mapRowToParkForecast(SqlRowSet row) { //go to each row of the table and fetch the values 
		Weather parkForecast = new Weather();
		parkForecast.setParkCode(row.getString("parkcode"));
		parkForecast.setFiveDayForecastValue(row.getInt("fivedayforecastvalue"));
		parkForecast.setLow(row.getInt("low"));
		parkForecast.setHigh(row.getInt("high"));
		parkForecast.setForecast(row.getString("forecast"));
		parkForecast.setDays(row.getInt("fivedayforecastvalue"));

		return parkForecast;

	}

	

}
