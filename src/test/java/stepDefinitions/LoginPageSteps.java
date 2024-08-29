package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import qa.factory.DriverFactory;

public class LoginPageSteps 
{
	private static String Title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getdriver());
	
	@Given("the user is on the Login page")
	public void the_user_is_on_the_login_page() 
	{
		DriverFactory.getdriver().get("https://adactin.capstonesystemdev.com.au/login");	    
	}

	@When("the user gets the title of the page")
	public void the_user_gets_the_title_of_the_page() 
	{
		Title =  loginPage.gettitle();	  
		System.out.println("Title is : " + Title);
	}

	@Then("the title of the page should be {string}")
	public void the_title_of_the_page_should_be(String expectedTitle) 
	{
	    Assert.assertTrue(Title.contains(expectedTitle));
	}

	@When("the user logins using the \"(.*)\" and \"(.*)\"$")
	public void the_user_enters_the_and(String usernm, String pwd) 
	{
		loginPage.enterusernmpwd(usernm, pwd);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() 
	{
		loginPage.clikLoginBtn();
	    
	}

}
