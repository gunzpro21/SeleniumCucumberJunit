package stepdefinitions;

import contextControls.Supervisor;
import cucumber.api.java.en.Given;
import pageobjects.HomePage;

/**
* <h1>Add some steps</h1>
* The HomePage_Steps controls all step for a script that use the elements of a specific page.

* @author  Phan
* @since   2018 Oct 25th
*/

public class HomePage_Steps {
	Supervisor supervisor;
	HomePage homePage;
	
	public HomePage_Steps(Supervisor sSupervisor) {
		supervisor = sSupervisor;
		homePage = supervisor.getPageObjectManager().getHomePage();
	}
	
	@Given("^user goes to Home Page$")
	public void user_is_on_Home_Page(){
		homePage.navigateTo_HomePage();	
	}
}
