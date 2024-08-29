package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/appfeatures/UserDashboard.feature"},
		glue = {"stepDefinitions"},
		plugin = {"pretty"
				}
		
		)

public class MyTestRunner {

}
