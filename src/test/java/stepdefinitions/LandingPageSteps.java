package stepdefinitions;

import org.junit.Assert;

import contextControls.Supervisor;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.LandingPage;
/**
* <h1>Add some steps</h1>
* The LandingPage_Steps controls all step for a script that use the elements of a specific page.

* @author  Joe Phan
* @since   2023 Feb 16th
*/
public class LandingPageSteps {
	Supervisor supervisor;
	LandingPage landingPage;
	
	public LandingPageSteps (Supervisor s_supervisor) {
		supervisor = s_supervisor;
		landingPage = supervisor.getPageObjectManager().getLandingPage();
	}
	
	@Then("^Degree Finder Page displays$")
	public void the_First_landing_page_is_loaded() throws Throwable {
		Assert.assertEquals("Degree Finder", landingPage.getTextheaderPage());
	}
	
	@When("^User chooses Arizona State University$")
	public void user_chooses_Arizona_State_University() throws Throwable {
		landingPage.clicklbArizona();
	}
}
