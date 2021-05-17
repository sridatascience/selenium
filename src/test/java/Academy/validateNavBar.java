package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.landingPage;

import resources.base;

public class validateNavBar extends base {
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(validateNavBar.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
	}

	@Test
	public void validateAppNavBar() throws IOException {
		
		driver.get(prop.getProperty("url") );
		log.info("Successfully navigaged to home page");
		
		//one is inheritance which is done by calling extends base
		//creating object to that class and invoke methods of it
		
		landingPage lp = new landingPage(driver);
		
		Assert.assertTrue(lp.getNavBarContact().isDisplayed());
		log.info("Navigation bar displayed");		
		
	}
	
	@AfterTest
	public void teardown() {
//		System.out.println("In ValidateNavBar teardown");
		driver.close();
		log.info("Driver is Closed");
	}
	
	

}
