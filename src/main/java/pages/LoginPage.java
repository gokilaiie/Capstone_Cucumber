package pages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;

	// By Locators
	private By username = By.xpath("//input[contains(@type,\"email\")]");
	// By.id("mat-input-3");
	private By password = By.xpath("//input[contains(@type,'password')]");
	// By.id("mat-input-4");
	private By LoginBtn = By.xpath("//button[@type='submit']");
	private By FrgtPwd = By.xpath("//span[text() ='Click here to reset']");

	private By OtpSection = By.xpath("//h1[text()= 'Where would you like to receive OTP ?']");
	private By EmailRadioBtn = By.xpath("//input[@value='EMAIL_PIN']");
	private By SendBtn = By.xpath("//button[@type='submit']");
	private By SubmitBtn = By.xpath("//span[text()= 'Submit ']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions
	public String gettitle() {
		return driver.getTitle();
	}

	public void enterusernmpwd(String usernm, String pwd) {
		driver.findElement(username).sendKeys(usernm);
		driver.findElement(password).sendKeys(pwd);
	}

	public void clikLoginBtn() {
		driver.findElement(LoginBtn).click();

		// Explicit Wait for page loading
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(OtpSection));

		// OTP section if appears
		if (driver.findElement(OtpSection).isDisplayed()) {
			driver.findElement(EmailRadioBtn).click();
			driver.findElement(SendBtn).click();
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(TimeoutException.class);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SubmitBtn));// driver.findElement(SubmitBtn)
			element.click();
		}
	}

	public boolean FrgtPwdisdisplayed() {
		return driver.findElement(FrgtPwd).isDisplayed();
	}

	public UserDashboardPage doLogin(String usernm, String pwd) {
		driver.findElement(username).sendKeys(usernm);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(LoginBtn).click();

		// Explicit Wait for page loading
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(OtpSection));

		// OTP section if appears
		if (driver.findElement(OtpSection).isDisplayed()) 
		{
			driver.findElement(EmailRadioBtn).click();
			driver.findElement(SendBtn).click();
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(TimeoutException.class);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(SubmitBtn));// driver.findElement(SubmitBtn)
			element.click();
			
		}
		return new UserDashboardPage(driver);
		

	}
}
