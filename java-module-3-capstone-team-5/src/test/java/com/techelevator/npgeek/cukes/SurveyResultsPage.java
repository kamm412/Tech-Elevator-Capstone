package com.techelevator.npgeek.cukes;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;

	public class SurveyResultsPage {

		private WebDriver webDriver;
		
		public SurveyResultsPage(WebDriver webDriver) {
			this.webDriver = webDriver;
		}

		public String getSurveyResults() {
			return webDriver.findElement(By.xpath("")).getText();
		}
		
		public String getTitle() {
			return webDriver.getTitle();
		}

	}