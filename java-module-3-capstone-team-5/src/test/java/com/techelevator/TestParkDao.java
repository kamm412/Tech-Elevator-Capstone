package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.dao.JDBCParkDAO;
import com.techelevator.dao.ParkDAO;
import com.techelevator.model.Park;

public class TestParkDao extends DAOIntegrationTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCParkDAO sut;
	private String parkCode;
	private ParkDAO parkDao;

	@Before
	public void setUp() throws Exception {
		sut = new JDBCParkDAO(getDataSource());

		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		String newPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING parkcode";
		parkCode = jdbcTemplate.queryForObject(newPark, String.class, "T1", "My Park Test", "PA", 101, 200, 10.0, 4, "GreenTree", 1990,
				20, "hello", "hi", "park is good", 10, 25);
	}

	@Test
	public void test() {
		List<Park> allParks = sut.getAllParks();

		for (Park park : allParks) {
			if (park.getParkName().equals("TEST") && park.getParkCode().equals(parkCode)) {
				assertEquals(parkCode, park.getParkCode());
				assertEquals("TEST", park.getParkName());
				return;
			}
		}
		fail("No parks found");
	}
	
}
