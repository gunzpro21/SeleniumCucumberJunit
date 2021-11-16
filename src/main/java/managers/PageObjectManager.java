package managers;

import org.openqa.selenium.WebDriver;

import pageobjects.CommonPage;
import pageobjects.HomePage;
import pageobjects.HoomePageKar;
import pageobjects.LandingPage;
import pageobjects.LogginKarrosPage;
import pageobjects.StudentPage;

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
	private LandingPage landingPage;
	private LogginKarrosPage logginKarrosPage;
	private StudentPage studentPage;
	private HoomePageKar hoomePageKar;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}

	public LogginKarrosPage getlogginKarrosPage() {
		return (logginKarrosPage == null) ? logginKarrosPage = new LogginKarrosPage(driver) : logginKarrosPage;
	}
	
	public StudentPage getStudentPage() {
		return (studentPage == null) ? studentPage = new StudentPage(driver) : studentPage;
	}
	
	public HoomePageKar getHoomePageKar() {
		return (hoomePageKar == null) ? hoomePageKar = new HoomePageKar(driver) : hoomePageKar;
	}
	
	public CommonPage getCommonPage() {
		return (commonPage == null) ? commonPage = new CommonPage(driver) : commonPage;
	}

	public LandingPage getLandingPage() {
		return (landingPage == null) ? landingPage = new LandingPage(driver) : landingPage;
	}
}
