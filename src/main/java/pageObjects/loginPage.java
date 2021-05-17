package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	

	//Constructor
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By loginBtn = By.xpath("//input[@value='Log In']");
	
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement clickLoginBtn() {
		return driver.findElement(loginBtn);
	}

}
