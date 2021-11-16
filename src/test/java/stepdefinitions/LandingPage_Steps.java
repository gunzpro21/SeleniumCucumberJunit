package stepdefinitions;

import org.junit.Assert;

import contextControls.Supervisor;
import cucumber.api.java.en.Then;
import pageobjects.LandingPage;
/**
* <h1>Add some steps</h1>
* The LandingPage_Steps controls all step for a script that use the elements of a specific page.

* @author  Phan
* @since   2018 Oct 25th
*/
public class LandingPage_Steps {
	Supervisor supervisor;
	LandingPage landingPage;
	
	public LandingPage_Steps (Supervisor s_supervisor) {
		supervisor = s_supervisor;
		landingPage = supervisor.getPageObjectManager().getLandingPage();
	}
	
	@Then("^the First landing page is loaded$")
	public void the_First_landing_page_is_loaded() throws Throwable {
		Assert.assertEquals("Degree Finder", landingPage.getTextheaderPage());
	}

	@Then("^the searching textbox is blank$")
	public void the_searching_textbox_is_blank() throws Throwable {
		Assert.assertTrue(landingPage.getTexttxtSearchingDegrees().isEmpty()); 
	}
}
