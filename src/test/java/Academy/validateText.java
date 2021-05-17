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

public class validateText extends base {
	public WebDriver driver;
	landingPage lp;
	private static Logger log = LogManager.getLogger(validateText.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
	}

	@Test
	public void validateAppTitle() throws IOException {

		driver.get(prop.getProperty("url"));
		log.info("Successfully navigaged to validateAppTitle page");
		// one is inheritance which is done by calling extends base
		// creating object to that class and invoke methods of it

		lp = new landingPage(driver);
		// Compare the Text from the browser with the actual text.
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message in ValidateAppTitle");

	}

	@Test
	public void validateHeader() {

		// Compare the Text from the browser with the actual text.
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Successfully validated text message in validateHeader");

	}

	@AfterTest
	public void teardown() {
//		System.out.println("In validate text teardown");
		driver.close();
		log.info("Driver is Closed");
	}

}
