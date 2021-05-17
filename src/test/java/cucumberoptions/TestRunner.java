package cucumberoptions;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)  //for directly running TestRunner file using Junit
@CucumberOptions(
		features= "src/test/java/features",
		glue = "stepDefinitions",
		monochrome=true)

public class TestRunner{
	
}


