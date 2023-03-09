package stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import contextControls.Supervisor;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.DegreeGrid;
import pageobjects.DegreeFinderResultPage;

public class DegreeFinderResultSteps {

	Supervisor supervisor;
	DegreeFinderResultPage degreeFinderResultPage;

	public DegreeFinderResultSteps(Supervisor sSupervisor) {
		supervisor = sSupervisor;
		degreeFinderResultPage = supervisor.getPageObjectManager().getDegreeFinderResultPage();
	}

	@Then("^Degree Finder belong to \"([^\"]*)\" displays$")
	public void the_First_landing_page_is_loaded(String expectingUniversity) throws Throwable {
		Assert.assertEquals(expectingUniversity, degreeFinderResultPage.getTextfirstResultFilter());
	}

	@When("^User search data degree$")
	public void user_search_data_degree() throws Throwable {
		degreeFinderResultPage.sendKeystxtSearch("data" +Keys.ENTER);
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
