package stepDefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.UserDashboardPage;
import qa.factory.DriverFactory;

public class UserDashboardSteps {

	private static String Title;
	private LoginPage LoginPage = new LoginPage(DriverFactory.getdriver());
	private UserDashboardPage UserDashboardPage;

	@Given("The user is already logged into the application")
	public void the_user_is_already_logged_into_the_application(io.cucumber.datatable.DataTable CredTable) 
	{
		List<Map<String, String>> CredList = CredTable.asMaps();

		String UserNm = CredList.get(0).get("username");
		String Passwrd = CredList.get(0).get("password");

		System.out.println("Logs in using  : " + UserNm + Passwrd);

		DriverFactory.getdriver().get("https://adactin.capstonesystemdev.com.au/login");

		UserDashboardPage = LoginPage.doLogin(UserNm, Passwrd);

	}

	@Given("The user is on the User Dashboard Page")
	public void the_user_is_on_the_user_dashboard_page() {

		Title = UserDashboardPage.Gettitle();

	}

	@When("the User clicks on the Internal Companies")
	public void the_user_clicks_on_the_internal_companies() {
		UserDashboardPage.navtoIntrnlCopmpany();

	}

	@Then("the user clicks on the Create New button")
	public void the_user_clicks_on_the_create_new_button() {

		UserDashboardPage.ClikCreateNewBtn();

	}

	@When("the user enters the {string}, {string},{string},{string} and {string}")
	public void the_user_enters_the_and(String CompanyColor, String Status, String IntrnlCmpnyNm,
			String IntrnlCmpnyEmail, String CategryTyp) throws InterruptedException {
		UserDashboardPage.fillIntrnalcompanyForm(CompanyColor, Status, IntrnlCmpnyNm, IntrnlCmpnyEmail, CategryTyp);

	}

	@When("the user clicks on the Create Company button")
	public void the_user_clicks_on_the_create_company_button() {
		// UserDashboardPage.createCmpnyBtn();

	}
	
	@Then("the user clicks on the {string}")
	public void the_user_clicks_on_the(String string) {
	}

}
