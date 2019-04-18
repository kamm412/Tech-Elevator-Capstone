package com.techelevator.model;

import java.math.BigDecimal;

public class Park {

	private String parkCode;
	private String parkName;
	private String state;
	private BigDecimal acreage;
	private BigDecimal elevationInFeet;
	private BigDecimal milesOfTrail;
	private int numberOfCampsite;
	private String climate;
	private String yearFounded;
	private long annualVisitorCount;
	private String inspirationalQuote;
	private String inspirationalQuotesource;
	private String description;
	private BigDecimal entryFee;
	private int numberOfAnimalSpecies;
	

	
	
	public String getYearFounded() {
		return yearFounded;
	}


	public void setYearFounded(String yearFounded) {
		this.yearFounded = yearFounded;
	}


	public long getAnnualVisitorCount() {
		return annualVisitorCount;
	}


	public void setAnnualVisitorCount(long annualVisitorCount) {
		this.annualVisitorCount = annualVisitorCount;
	}


	public String getQuote() {
		return inspirationalQuote;
	}


	public void setQuote(String quote) {
		this.inspirationalQuote = quote;
	}


	public String getQuoteSource() {
		return inspirationalQuotesource;
	}


	public void setQuoteSource(String quoteSource) {
		this.inspirationalQuotesource = quoteSource;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public BigDecimal getEntryFee() {
		return entryFee;
	}


	public void setEntryFee(BigDecimal entryFee) {
		this.entryFee = entryFee;
	}


	public int getNumberOfAnimalSpecies() {
		return numberOfAnimalSpecies;
	}


	public void setNumberOfAnimalSpecies(int numberOfAnimalSpecies) {
		this.numberOfAnimalSpecies = numberOfAnimalSpecies;
	}
	
	
	public String getParkCode() {
		return parkCode;
	}
	
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public BigDecimal getAcreage() {
		return acreage;
	}
	public void setAcreage(BigDecimal acreage) {
		this.acreage = acreage;
	}
	public BigDecimal getElevationInFeet() {
		return elevationInFeet;
	}
	public void setElevationInFeet(BigDecimal elevationInFeet) {
		this.elevationInFeet = elevationInFeet;
	}
	public BigDecimal getMilesOfTrail() {
		return milesOfTrail;
	}
	public void setMilesOfTrail(BigDecimal milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	public int getNumberOfCampsite() {
		return numberOfCampsite;
	}
	public void setNumberOfCampsite(int numberOfCampsite) {
		this.numberOfCampsite = numberOfCampsite;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}

	
	
	
}

