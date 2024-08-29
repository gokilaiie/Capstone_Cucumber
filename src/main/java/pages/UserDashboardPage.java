package pages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDashboardPage {
	
	private WebDriver driver;
	
	private By menu = By.xpath("//mat-icon[@title='Toggle menu']");
	private By syMngmt = By.xpath("//div[@class='main-menu-name ng-star-inserted' and text()='Systems Management']");
	private By Entities = By.xpath("//div[text()='Entities' and @class='sub-menu-name ng-star-inserted']");
	private By InternalCmpany= By.xpath("//div[text()='Internal Companies ' and @class='sub-menu-name ng-star-inserted']");
	private By CreateNewBtn = By.xpath("//span[normalize-space()='Create New']");
	
	//Constructor
	public UserDashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String Gettitle()
	{
		return driver.getTitle();
	}
	
	public void navtoIntrnlCopmpany()
	{
		//wait for page load to click on menu
		
		  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
		  .pollingEvery(Duration.ofSeconds(5)).ignoring(TimeoutException.class);
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(menu));
		  element.click();
			/*
			 * Thread.sleep(3000); driver.findElement(menu);
			 */
		
		
		//wait for sys mgmt to load
		Wait<WebDriver> flwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(TimeoutException.class);
		WebElement sysmgmtelement = flwait.until(ExpectedConditions.elementToBeClickable(syMngmt));// driver.findElement(SubmitBtn)
		sysmgmtelement.click();
		
		//driver.findElement(syMngmt).click();
		driver.findElement(Entities).click();
		driver.findElement(InternalCmpany).click();
	}
	public void ClikCreateNewBtn()
	{
		driver.findElement(CreateNewBtn).click();
	}
	public void fillIntrnalcompanyForm(String CompanyColor, String Status, String IntrnlCmpnyNm, String IntrnlCmpnyEmail, String CategryTyp) throws InterruptedException
	{
		By Colorpickertxtbox = By.xpath("//input[@formcontrolname='CompanyColour']");
		By Statusdropdown = By.xpath("//mat-select[@formcontrolname='StatusId' and @role='combobox']");
		By IntrnlCmpnyNmTxtbox= By.xpath("//input[@formcontrolname='Name']");
		By IntrnlCmpnyEMailTxtbox= By.xpath("//input[@formcontrolname='Email']");
		By CategoryTypDrpdwn = By.xpath("//mat-select[@formcontrolname='CategoryTypeId' and @role='combobox']");
		
		
		driver.findElement(Colorpickertxtbox).clear();
		driver.findElement(Colorpickertxtbox).sendKeys(CompanyColor);
		
		  //selecting status 
		//Explicit wait for page loading
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Statusdropdown)));
	 	
	 	
	 	((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	 	
	 	//Selecting the value from dropdwn
	 	WebDriverWait elewait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement Activeele = elewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Active']")));
		Activeele.click();
	 	
		/*
		 * Select StatusDrpdwn = new Select(driver.findElement(Statusdropdown));
		 * StatusDrpdwn.selectByVisibleText(Status);
		 */
		
		//driver.findElement(Statusdropdown).sendKeys(Status);
		driver.findElement(IntrnlCmpnyNmTxtbox).sendKeys(IntrnlCmpnyNm);
		driver.findElement(IntrnlCmpnyEMailTxtbox).sendKeys(IntrnlCmpnyEmail);
		driver.findElement(CategoryTypDrpdwn).sendKeys(CategryTyp);
		
		
		
	}
	
	public void createCmpnyBtn()
	{
		By CreateCmpnyBtn = By.xpath("//span[@class='ng-star-inserted' and text()=' Create Company']");
		if(driver.findElement(CreateCmpnyBtn).isEnabled())
			driver.findElement(CreateCmpnyBtn).click();
	}

}
