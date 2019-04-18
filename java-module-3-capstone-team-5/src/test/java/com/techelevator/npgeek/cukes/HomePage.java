package com.techelevator.npgeek.cukes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.techelevator.dao.Survey;

public class HomePage {

	private WebDriver webDriver;

	public HomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public HomePage clickHomePageLink() {
		WebElement HomePageLink = webDriver.findElement(By.linkText("Home Page"));
		HomePageLink.click();
		return new HomePage(webDriver);
	}
	
	public Survey clickSurveyPageLink() {
		WebElement SurveyInputLink = webDriver.findElement(By.linkText("Survey Page"));
		SurveyInputLink.click();
		return new Survey();
	}
}
