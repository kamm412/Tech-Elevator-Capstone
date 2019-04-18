package com.techelevator.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.Survey;
import com.techelevator.dao.SurveyDao;
import com.techelevator.dao.SurveyResults;
import com.techelevator.dao.SurveyResultsDao;

	@Controller
	public class SurveyController {

		@Autowired //connecting to the dao 
		private SurveyDao surveyDao;
		
		@Autowired //connecting to the dao 
		private SurveyResultsDao surveyResultsDao;

		@RequestMapping(path = "/surveyInputPage", method = RequestMethod.GET)
		public String displaySurveyPage() {
			return "surveyInputPage"; //return the logical view name to view resolver 
		}
		
		@RequestMapping(path = "/surveyResultsPage", method = RequestMethod.POST)
		public String submitSurvey(@Valid @RequestParam String parkCode, @RequestParam String emailInput, @RequestParam String stateSelection, 
				@RequestParam String activityLevel) {
			System.out.println("In the POST method");
			Survey s = new Survey();
			s.setParkCode(parkCode);
			s.setEmailAddress(emailInput);
			s.setState(stateSelection);
			s.setActivityLevel(activityLevel);
			surveyDao.save(s);		
			
			return "redirect:/surveyResultsPage"; //redirecting to a get after the post method  
		}

		@RequestMapping(path = "/surveyResultsPage", method = RequestMethod.GET)
		public String displaySurveyResults(ModelMap modelHolder) {		
			List<SurveyResults> surveyResults = surveyResultsDao.getSurveyByCount();
			
			modelHolder.put("surveyResults", surveyResults);
			
			return "surveyResultsPage"; //return the logical view name to view resolver 
		}

	}