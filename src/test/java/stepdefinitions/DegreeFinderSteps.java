package stepdefinitions;

import org.junit.Assert;

import contextControls.Supervisor;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.DegreeFinderPage;
/**
* <h1>Add some steps</h1>
* The LandingPage_Steps controls all step for a script that use the elements of a specific page.

* @author  Joe Phan
* @since   2023 Feb 16th
*/
public class DegreeFinderSteps {
	Supervisor supervisor;
	DegreeFinderPage dFPage;
	CommonPageSteps commonsteps;
	public DegreeFinderSteps (Supervisor s_supervisor) {
		supervisor = s_supervisor;
		dFPage = supervisor.getPageObjectManager().getLandingPage();
		commonsteps =new CommonPageSteps(s_supervisor);
	}
	
	@Then("^Degree Finder Page displays$")
	public void the_First_landing_page_is_loaded() throws Throwable {
		Assert.assertEquals("Degree Finder", dFPage.getTextheaderPage());
	}
	@When("^User wants to searches some degrees of Arizona State University$")
	public void user_wants_to_searches_some_degrees_of_Arizona_State_University() throws Throwable {
		commonsteps.user_have_clicked_Choose_your_university_on_Main_page();
		dFPage.clicklbArizona();
	}
	
}
