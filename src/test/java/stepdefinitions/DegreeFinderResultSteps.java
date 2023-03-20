package stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import com.vimalselvam.cucumber.listener.Reporter;

import contextControls.Supervisor;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.DegreeGrid;
import pageobjects.DegreeFinderResultPage;

public class DegreeFinderResultSteps {

	Supervisor supervisor;
	DegreeFinderResultPage degreeFinderResultPage;
	DegreeFinderSteps degreeFinderSteps;
	public DegreeFinderResultSteps(Supervisor sSupervisor) {
		supervisor = sSupervisor;
		degreeFinderResultPage = supervisor.getPageObjectManager().getDegreeFinderResultPage();
		degreeFinderSteps = new DegreeFinderSteps(sSupervisor);
	}

	@Then("^degrees belong to \"([^\"]*)\" displays$")
	public void degrees_belong_to_displays(String expectingUniversity) throws Throwable {
		Reporter.assignAuthor("Author - Truong Phan");
		Assert.assertEquals(expectingUniversity, degreeFinderResultPage.getTextfirstResultFilter());
	}
	
	@When("^User searches \"([^\"]*)\" degrees of Arizona State University$")
	public void user_searches_degrees_of_Arizona_State_University(String seachingDegree) throws Throwable {
		degreeFinderSteps.user_wants_to_searches_some_degrees_of_Arizona_State_University();
		degreeFinderResultPage.sendKeystxtSearch(seachingDegree +Keys.ENTER);
	}
	
	@Then("^the following related results are shown$")
	public void the_following_related_results_are_shown(List<Map<String, String>> data) throws Throwable {
		DegreeGrid expectedData = new DegreeGrid();
		DegreeGrid realData = new DegreeGrid();
		for (int i = 0; i < data.size(); i++) {

			expectedData.setDegreeName(data.get(i).get("degree name"));
			expectedData.setUniversity(data.get(i).get("university"));
			expectedData.setUniversityCountry(data.get(i).get("university country"));

			realData.setDegreeName(degreeFinderResultPage.getTextlstDegreesOnGrid(i));
			realData.setUniversity(degreeFinderResultPage.getTextlstUniversitiesOnGrid(i));
			realData.setUniversityCountry(degreeFinderResultPage.getTextlstCountriesOnGrid(i));
			System.out.printf("%s -u: %s, country: %s\n", data.get(i).get("degree name"), data.get(i).get("university"),
					data.get(i).get("university country"));
			assertTrue(expectedData.equals(realData));
		}
	}
}
