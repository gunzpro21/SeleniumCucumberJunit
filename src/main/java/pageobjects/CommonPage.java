package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import managers.FileReaderManager;
import utilities.Utils;

/**
* <h1>CommonPage!</h1>
* The CommonPage place all locator and function for top bar navigation menu and footer. that display almost all pages.

* @author  Phan
* @since   2018 Oct 30th
*/
public class CommonPage {
	WebDriver driver;
	
	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, FileReaderManager.getInstance().getConfigReader().getExplicitlyWait()), this);
	}
	
	@FindBy(linkText = "Study with us") 
	private WebElement subMenuStudyWithUs;
	
	@FindBy(xpath = "//header['kihe-main-header-desktop fixed-menu shadow-bottom']//span[@class='sub-menu-item-title' and text()='Degree Finder']") 
	private WebElement subMenuDegreeFinder;
	
	public void clicksubMenuDegreeFinder() {
		Utils.hoverAndClick(driver, subMenuStudyWithUs, subMenuDegreeFinder);
	}
}
