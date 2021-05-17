package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
	}

	
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password,String text) throws IOException {
		
		
		driver.get(prop.getProperty("url") );
		//one is inheritance which is done by calling extends base
		//creating object to that class and invoke methods of it
		
		landingPage lp = new landingPage(driver);
		lp.getLogin().click();
		log.info("Log Button clicked");
		
		loginPage lgp = new loginPage(driver);
		lgp.getEmail().sendKeys(username);
		log.info("Email id filled");
		lgp.getPassword().sendKeys(password);
		log.info("Password filled");
		log.info(text);
		lgp.clickLoginBtn().click();
		log.info("LoginButton clicked");
		
	}
	
	@DataProvider
	
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		data[0][0] = "user1@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "restircted user1";
		
		data[1][0] = "user2@gmail.com";
		data[1][1] = "12345678";
		data[1][2] = "restircted user2";
		return data;
	}
	
	@AfterTest
	public void teardown() {
//		System.out.println("In HomePage teardown");
		driver.quit();
		log.info("Driver is Closed");
	}

}
