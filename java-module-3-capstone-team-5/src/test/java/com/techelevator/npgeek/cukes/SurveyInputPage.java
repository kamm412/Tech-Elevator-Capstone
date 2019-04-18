package com.techelevator.npgeek.cukes;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SurveyInputPage {
	
	private static WebDriver webDriver1;
	
	/* Creating an instance of the WebDriver is time consuming
	 * since it opens up a browser window. Therefore, we do this
	 * only once at the start of the class and reuse the same
	 * browser window for all tests. */
	@BeforeClass
	public static void openWebBrowserForTesting() {
		
		String homeDir = System.getProperty("user.home"); // ~ or $HOME
		/* The ChromeDriver requires a system property with the name "webdriver.chrome.driver" that
		 * contains the directory path to the ChromeDriver executable. The following line assumes
		 * we have installed the ChromeDriver in a known location under our home directory */
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver1 = new ChromeDriver();
	}

	@Before
	public void openHomePage() {
		webDriver1.get("http://localhost:8080/m3-java-capstone/surveyInputPage/");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver1.close();
	}



//	public SurveyInputPage(WebDriver webDriver) {
//		this.webDriver1 = webDriver;
//	}
//	
	@Test
	public void clickSurveyLink() {
		WebElement surveyLink = webDriver1.findElement(By.xpath("/html/body/nav/ul/li[2]/a"));
		surveyLink.click();
		//return new SurveyInputPage (webDriver1);
	}
	@Test
	public void clickCheckParkDropDownLink() {
		WebElement dropDown = webDriver1.findElement(By.xpath("//*[@id=\"parkCode\"]"));
		dropDown.click();
		//return new SurveyInputPage(webDriver1);
	}
	@Test
	public void selectFromDropDown() {
		WebElement dropDownSelect = webDriver1.findElement(By.id("parkCode"));
		dropDownSelect.click();
		//return new SurveyInputPage(webDriver1);
	}
	
	@Test
	public void  enterEmailAddress() {
		WebElement emailAddress = webDriver1.findElement(By.xpath("//*[@id=\"emailInput\"]"));
		emailAddress.sendKeys("Kaelin@gmail.com");
		//return this;
	}
	@Test
	public void  enterStateOfResidence() {
		WebElement dropDown = webDriver1.findElement(By.xpath("//*[@id=\"command\"]/div[3]/label"));
		dropDown.click();
		//return this;
	}
	@Test
	public void  selectFromDropDownState() {
		WebElement stateDropDown = webDriver1.findElement(By.id("stateSelection"));
		stateDropDown.click();
		//return this;
	}
	@Test
	public void  enterActivityLevel() {
		WebElement dropDown = webDriver1.findElement(By.xpath("//*[@id=\"command\"]/div[4]/label"));
		dropDown.click();
		//return this;
	}
	@Test
	public void  selectActivityLevel() {
		WebElement selectRadio = webDriver1.findElement(By.name("activityLevel"));
		selectRadio.click();
		//return this;
	}
	
	
	@Test
	public void submitForm() {
		WebElement submitButton = webDriver1.findElement(By.name("Submit"));
		submitButton.click();
		//return new SurveyInputPage(webDriver1);
	}
	@Test
	public void single_elements_can_be_found_by_tag_name() {
		WebElement header = webDriver1.findElement(By.tagName("header"));
		WebElement footer = webDriver1.findElement(By.tagName("footer"));
		assertNotNull(header);
		assertNotNull(footer);
	}
}

