package stepdefinitions;

import contextControls.Supervisor;
import cucumber.api.java.en.Given;
import pageobjects.HoomePageKar;
import pageobjects.LogginKarrosPage;
import pageobjects.StudentPage;

/**
 * <h1>Add some steps</h1> The LoginKarrosPage_Steps controls all step for a
 * script that use the elements of a specific page.
 * 
 * @author Truong Phan
 * @since 2021 Apr 25
 */
public class LoginKarrosPage_Steps {
	Supervisor supervisor;
	LogginKarrosPage logginKarrosPage;
	HoomePageKar hoomePageKar;
	StudentPage studentPage;

	public LoginKarrosPage_Steps(Supervisor s_supervisor) {
		supervisor = s_supervisor;
		logginKarrosPage = supervisor.getPageObjectManager().getlogginKarrosPage();

	}

	@Given("^I am logged in the system$")
	public void i_am_logged_in_the_system() {
		logginKarrosPage.navigateToLogginKarrosPage().login();
	}
}
