package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDao, SurveyResultsDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired  //connecting to DB
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//fetching votecount, parkname FROM survey_result using sql statements
	@Override
	public List<SurveyResults> getSurveyByCount() {
		List<SurveyResults> surveyTopParks = new ArrayList<>();
		String sqlSelectCountOfReviews = "SELECT COUNT(*) votecount, parkname FROM survey_result JOIN park ON park.parkcode = survey_result.parkcode GROUP BY parkname ORDER BY votecount DESC, parkname ASC";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectCountOfReviews);
		while(results.next()) {
			SurveyResults surveyResults = new SurveyResults();
			surveyResults.setParkName(results.getString("parkname"));
			surveyResults.setVoteCount(results.getInt("votecount"));
			surveyTopParks.add(surveyResults);
		}
		return surveyTopParks;
	}

	//saved the result of survey
	@Override
	public void save(Survey survey) {
		Long surveyId = getNextId();
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, surveyId, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		survey.setSurveyId(surveyId);
	}
	
	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long surveyId = null;
		if(results.next()) {
			surveyId = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
		}
		return surveyId;
	}

	


}


