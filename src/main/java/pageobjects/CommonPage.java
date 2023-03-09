package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


/**
 * <h1>CommonPage!</h1> The CommonPage place all locator and function for top
 * bar navigation menu and footer. that display almost all pages.
 * 
 * @author Phan
 * @since 2023 Feb 17th
 */
public class CommonPage  extends BasePage {

	public CommonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeOut), this);
	}

	@FindBy(linkText = "Study with us")
	private WebElement subMenuStudyWithUs;

	@FindBy(xpath = "//header['kihe-main-header-desktop fixed-menu shadow-bottom']//span[@class='sub-menu-item-title' and text()='Degree Finder']")
	private WebElement subMenuDegreeFinder;

	@FindBy(id = "ccc-notify-accept")
	private WebElement btnAcceptCookie;

	public void clickbtnAcceptCookie() {
		clickClickableElement(driver, btnAcceptCookie);
	}

	public void clicksubMenuDegreeFinder() {
		hoverAndClick(driver, subMenuStudyWithUs, subMenuDegreeFinder);
	}
}
