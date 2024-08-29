package qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
		}
		else
		{
			System.out.println("Enter correct browser name : " + browser);
		}
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();
		return getdriver();
		
	}
	
	public static synchronized WebDriver getdriver()
	{
		return tldriver.get();
		
	}
	

}
