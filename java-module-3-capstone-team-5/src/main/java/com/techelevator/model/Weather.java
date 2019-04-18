package com.techelevator.model;

public class Weather {

	private String parkCode;
	private int fiveDayForecastValue;
	private int days;
	private int low;
	private int high;
	private String forecast;
	
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int lowTemp) {
		this.low = lowTemp;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int highTemp) {
		this.high = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int daysAsInt) {
		this.days = daysAsInt;
	}

}




