package managers;

import org.openqa.selenium.WebDriver;

import pageobjects.CommonPage;
import pageobjects.DegreeFinderResultPage;
import pageobjects.HomePage;
import pageobjects.DegreeFinderPage;


/**
 * <h1>Add a driver!</h1> The PageObjectManager control all page objects in the
 * project. We create one class but control all pages.
 * 
 * @author Phan
 * @since 2018 Oct 25th
 */

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private CommonPage commonPage;
	private DegreeFinderPage landingPage;
	private DegreeFinderResultPage degreeFinderResultPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public CommonPage getCommonPage() {
		return (commonPage == null) ? commonPage = new CommonPage(driver) : commonPage;
	}

	public DegreeFinderPage getLandingPage() {
		return (landingPage == null) ? landingPage = new DegreeFinderPage(driver) : landingPage;
	}

	public DegreeFinderResultPage getDegreeFinderResultPage() {
		return (degreeFinderResultPage == null) ? degreeFinderResultPage = new DegreeFinderResultPage(driver) : degreeFinderResultPage;
	}
}
