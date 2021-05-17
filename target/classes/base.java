package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		//System.getProperty("user.dir")
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		prop.load(fs);
		//mvn test -Dbrowser=chrome 
		//checks the maven issued option as above and assign it browserName variable , this is how we store the options
		//issued from Maven command using System.getProperty
//		String browserName = System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");
		System.out.println("------In the base File------------");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sridharvumma\\Testing\\selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
			//Options to enable headless mode - that is to execute tests without calling the browser
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\sridharvumma\\Testing\\selenium\\drivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
