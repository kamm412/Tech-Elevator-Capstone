package com.techelevator.npgeek.cukes;


import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.Before;

public class Hooks {

	private @Autowired
	static WebDriver webDriver;
	
	@Before
	public void setup() {
		webDriver.manage().deleteAllCookies();
		webDriver.get("http://localhost:8080/m3-java-capstone/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
	}
	
}

