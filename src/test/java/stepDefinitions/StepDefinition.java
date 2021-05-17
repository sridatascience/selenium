package stepDefinitions;

import io.cucumber.junit.Cucumber;
import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;



import org.junit.runner.RunWith;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(Cucumber.class)

public class StepDefinition extends base {
	
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
	    driver = initializeDriver();
	}
	
	@And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);
    }
	
	@And("^Click on Login Link in Home Page to land on Secure Sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		landingPage lp = new landingPage(driver);
		if(lp.getPopupSize()>0) {
			lp.getPopup().click();
		}
		lp.getLogin().click();
    }
	
//	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logsin $")
//	@When("User enters {string} and {string} and logsin")	
	@When("^User enters (.+) and (.+) and logsin$")
	public void user_enters_and_and_logsin(String username, String password) throws Throwable {
		loginPage lgp = new loginPage(driver);
		lgp.getEmail().sendKeys(username);		
		lgp.getPassword().sendKeys(password);
		lgp.clickLoginBtn().click();
    }
	
//	@Then("^verify that user is successfully loggedin$")
//    public void verify_that_user_is_successfully_loggedin() throws Throwable {
//	    System.out.println("Verified successful login");
//	}
	
	@And("^close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

}
