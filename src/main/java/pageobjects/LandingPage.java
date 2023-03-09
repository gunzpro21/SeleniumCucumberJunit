package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



/**
* <h1>LandingPage!</h1>
* The LandingPage places all locators and functions for /degree-finder/#/landing.

* @author  Phan
* @since   2018 Oct 30th
*/
public class LandingPage extends BasePage {
	
	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeOut), this);
	}
	
	@FindBy(tagName = "h1") 
	private WebElement headerPage;

	@FindBy(css = ".dgf-search >input") 
	private WebElement txtSearchingDegrees;
	
	@FindBy(xpath = "//p[text()='Arizona State University']") 
	private WebElement lbArizona;
	
	public void clicklbArizona() {
		clickClickableElement(driver, lbArizona);
	}

	public String getTexttxtSearchingDegrees() {
		return getTextVisibleElement(driver, txtSearchingDegrees);
	}
	
	public String getTextheaderPage() {
		return getTextVisibleElement(driver, headerPage);
	}
	
}
