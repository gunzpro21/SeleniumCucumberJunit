package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utils;

/**
* <h1>LandingPage!</h1>
* The LandingPage places all locators and functions for /degree-finder/#/landing.

* @author  Phan
* @since   2018 Oct 30th
*/
public class LandingPage {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName = "h1") 
	private WebElement headerPage;

	@FindBy(css = ".dgf-search >input") 
	private WebElement txtSearchingDegrees;
	
	public String getTexttxtSearchingDegrees() {
		return txtSearchingDegrees.getText();
	}

	public String getTextheaderPage() {
		return headerPage.getText();
	}
	
}
