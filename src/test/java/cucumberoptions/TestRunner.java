package cucumberoptions;


import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)   //commented for integrating with Testng, uncomment it for directly running TestRunner file using Junit
@CucumberOptions(
		features= "src/test/java/features",
		glue = "stepDefinitions",
		monochrome=true)

public class TestRunner{
	
}


//public class TestRunner extends AbstractTestNGCucumberTests {
//
//}
