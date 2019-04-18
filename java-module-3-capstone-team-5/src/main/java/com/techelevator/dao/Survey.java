package com.techelevator.dao;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

private Long surveyId;
	
	@NotBlank(message="Park Code is Required") 
	private String parkCode;
	
	@NotBlank(message="Email id Required") 
	@Email(message="Please provide a valid Email address")
	private String emailAddress;
	
	@NotBlank(message="Email id Required") @Email(message="Email address doesn't match")
	private String confirmEmail;
	
	@NotBlank(message="State of residence is Required") 
	private String state;
	
	@NotBlank(message="Activity Level is Required") 
	private String activityLevel;

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}

	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}

}
