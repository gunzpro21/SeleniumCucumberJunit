package stepdefinitions;

import contextControls.Supervisor;
import cucumber.api.java.en.Given;
import pageobjects.CommonPage;
/**
* <h1>Add some steps</h1>
* The CommonPage_Steps controls all step for a script that use the elements of a specific page.

* @author  Phan
* @since   2018 Oct 25th
*/

public class CommonPageSteps {
	Supervisor supervisor;
	CommonPage commonPage;
	public CommonPageSteps(Supervisor s_supervisor) {
		supervisor = s_supervisor;
		commonPage = supervisor.getPageObjectManager().getCommonPage();
	}
	
	@Given("^User chooses Degree Finder on submenu$")
	public void user_have_clicked_Choose_your_university_on_Main_page() throws Throwable {
		commonPage.clickbtnAcceptCookie();
		commonPage.clicksubMenuDegreeFinder();
	}
}
