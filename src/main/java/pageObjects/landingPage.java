package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	

	//Constructor
	public landingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By login = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navbarcontact = By.xpath("//a[contains(text(),'Contact')]");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	private By popup  = By.xpath("//button[text()='NO THANKS']");
	
	
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
	public int getPopupSize() {
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBarContact() {
		return driver.findElement(navbarcontact);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
