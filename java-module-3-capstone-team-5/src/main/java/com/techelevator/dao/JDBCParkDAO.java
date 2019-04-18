package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Park;

@Component
public class JDBCParkDAO implements ParkDAO {

	
	private JdbcTemplate jdbcTemplate;
	
    @Autowired  //connecting to DB
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);  //jdbctemplate is a central class in JDBC core package 
	}
    
    
    //fetching park details using sql statements
	@Override
	public List<Park> getAllParks() {
		List<Park> parks = new ArrayList<>();
		String sqlGetAllParks = "SELECT * " + " FROM park " + " ORDER BY parkname";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
		
		while (results.next()) {   //incrementing cursor to the next element 
			Park thePark = mapRowToPark(results);
			parks.add(thePark);
		}
		return parks;
	}
	
//fetching park details by park code using sql statements
	@Override
	public Park getParkByCode(String parkCode) {
		Park park = null;
		String sqlSelectionParkCode = "SELECT * FROM park WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectionParkCode, parkCode);
		if (results.next()) {
			park = mapRowToPark(results);
		}
		return park;
	}

//	fetching data from each row
	private Park mapRowToPark(SqlRowSet results) {
		Park thePark = new Park();
		thePark.setParkCode(results.getString("parkcode"));
		thePark.setParkName(results.getString("parkname"));
		thePark.setState(results.getString("state"));
		thePark.setAcreage(results.getBigDecimal("acreage"));
		thePark.setElevationInFeet(results.getBigDecimal("elevationinfeet"));
		thePark.setMilesOfTrail(results.getBigDecimal("milesoftrail"));
		thePark.setNumberOfCampsite(results.getInt("numberofcampsites"));
		thePark.setClimate(results.getString("climate"));
		thePark.setYearFounded(results.getString("yearfounded"));
		thePark.setAnnualVisitorCount(results.getLong("annualvisitorcount"));
		thePark.setQuote(results.getString("inspirationalquote"));
		thePark.setQuoteSource(results.getString("inspirationalquotesource"));
		thePark.setDescription(results.getString("parkdescription"));
		thePark.setEntryFee(results.getBigDecimal("entryfee"));
		thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		
		return thePark;
	}

	
	
}
