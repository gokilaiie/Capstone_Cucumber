package stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.factory.DriverFactory;
import qa.util.ConfigReader;

public class ApplicationHooks
{
	private DriverFactory DriverFactory;
	private WebDriver driver;
	private ConfigReader ConfigReader;
	Properties prop;
	
	@Before(order = 0)
	public void getproperty()
	{
		ConfigReader = new ConfigReader();
		prop = ConfigReader.init_prop();
		System.out.println("properties init");
		
	}
	
	@Before(order = 1)
	public void launchbrowser()
	{
		String browserNm = prop.getProperty("browser");
		System.out.println("Browser is : " + browserNm);
		DriverFactory = new DriverFactory();
		driver = DriverFactory.init_driver(browserNm);
	}
	
	@After(order = 0)
	public void quitbrowser()
	{
		//driver.quit();
	}
	
	@After(order = 1)
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotNm = scenario.getName().replaceAll(" ","_");
			byte [] sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcepath, "img/png", screenshotNm);
			
		}
	}

}
